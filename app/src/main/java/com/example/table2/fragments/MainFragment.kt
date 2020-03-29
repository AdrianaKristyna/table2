package com.example.table2.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.table2.List2
import com.example.table2.R
import com.example.table2.adapters.CategoryAdapter
import com.example.table2.utils.formatPrice
import com.example.table2.viewModel.MainViewModel
import kotlinx.android.synthetic.main.fragment_list1.*
import kotlinx.android.synthetic.main.fragment_main.*

/*
* Main Fragment with list of categories
* */
class MainFragment : Fragment() {

    private var initialAmount = "0"
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        viewModel = activity?.let { ViewModelProvider(it).get(MainViewModel::class.java) }
                ?: throw RuntimeException("Activity is null") as Throwable
        viewModel.categoriesLiveData.observe(viewLifecycleOwner, Observer {
            val cheapCategory = it.first { it.name.contains("cheap", true) }

            ppr_voda_25_layout.findViewById<TextView>(R.id.amount).apply {
                text = viewModel.calculateTotalPrice(cheapCategory).formatPrice()
            }

            val expensiveCategory = it.first { it.name.contains("expensive", true) }

            htb_odpad_layout.findViewById<TextView>(R.id.amount).apply {
                text = viewModel.calculateTotalPrice(expensiveCategory).formatPrice()
            }
        })
    }

    /* TODO refactor to RecyclerView in future*/
    private fun initializeViews() {

        /* PPR Voda 25*/
        val buttonVoda = ppr_voda_25_layout.findViewById<Button>(R.id.button)
        buttonVoda.setText(R.string.ppr_voda_20)
        ppr_voda_25_layout.findViewById<TextView>(R.id.amount).apply {
            /* to je stejne jako setText() na TextView */
            text = initialAmount
        }

        /* HTB odpad*/
        val buttonHtb = htb_odpad_layout.findViewById<Button>(R.id.button)
        buttonHtb.setText(R.string.htb_odpad)
        val amountHtb = htb_odpad_layout.findViewById<TextView>(R.id.amount)
        amountHtb.text = initialAmount

        buttonVoda.setOnClickListener {
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.root_container, ListFragment(), ListFragment.TAG)
                    ?.addToBackStack(null)
                    ?.commit()
        }
        buttonHtb.setOnClickListener {
            val button2Intent = Intent(activity, List2::class.java)
            startActivity(button2Intent)
        }
    }

    companion object {
        const val TAG = "MainFragment"
    }
}