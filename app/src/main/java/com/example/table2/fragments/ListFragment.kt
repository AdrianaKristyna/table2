package com.example.table2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.table2.R
import com.example.table2.adapters.CategoryAdapter
import com.example.table2.model.Category
import com.example.table2.utils.formatPrice
import com.example.table2.viewModel.MainViewModel
import kotlinx.android.synthetic.main.fragment_list1.*

class ListFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    val categoryType = "cheap"

    private val onPlusClicked: (name: String) -> Unit = { name -> viewModel.incrementProduct(name) }

    private val onMinusClicked: (name: String) -> Unit = { name -> viewModel.decrementProduct(name) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_list1, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = activity?.let { ViewModelProvider(it).get(MainViewModel::class.java) }
                ?: throw RuntimeException("Activity is null")
        /*
       * take a product list from a category
       * here i select cheap but you can select by different method
       * */
        viewModel.categoriesLiveData.observe(viewLifecycleOwner, Observer {
            val category = viewModel.categories.first { it.name.contains(categoryType, true) }
            viewModel.selectedcategoryName = category.name
            (rvItems.adapter as CategoryAdapter).products.run {
                clear()
                addAll(category.products)
                rvItems.adapter?.notifyDataSetChanged()
            }
            tvPricePerItemValue.text = category.pricePerItem.formatPrice()
            tvTotalPriceValue.text = viewModel.calculateTotalPrice(category).formatPrice()
        })

        /* init header */
        tvCategoryName.text = getString(R.string.category1)


        /* init recyclerview*/
        initRecyclerview()
    }

    private fun initRecyclerview() {
        rvItems.adapter = CategoryAdapter(onPlusClicked, onMinusClicked)
        rvItems.layoutManager = LinearLayoutManager(context)
    }

    companion object {
        const val TAG = "List1Fragment"
    }
}