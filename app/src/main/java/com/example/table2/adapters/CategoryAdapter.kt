package com.example.table2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.table2.R
import com.example.table2.model.Product
import com.example.table2.utils.formatPrice
import kotlinx.android.synthetic.main.list_item_category.view.*

class CategoryAdapter(
        private val onPlusClicked: (name: String) -> Unit,
        private val onMinusClicked: (name: String) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryVH>() {

    var products: ArrayList<Product> = arrayListOf()

    class CategoryVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.tvName
        val price: TextView = itemView.tvPricePerItem
        val count: TextView = itemView.tvProductCount
        val buttonPlus: Button = itemView.btPlus
        val buttonMinus: Button = itemView.btMinus
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        return CategoryVH(LayoutInflater.from(parent.context).inflate(R.layout.list_item_category, parent, false))
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        val product = products[position]

        holder.name.text = product.name
        holder.price.text = product.price.formatPrice()
        holder.count.text = product.count?.toString() ?: "0"

        holder.buttonPlus.setOnClickListener {
            onPlusClicked(product.name)
        }

        holder.buttonMinus.setOnClickListener {
            onMinusClicked(product.name)
        }
    }
}