package com.example.table2.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.table2.model.Category
import com.example.table2.model.Product

class MainViewModel : ViewModel() {

    var selectedcategoryName: String = ""

    private val items1 = arrayListOf(
            Product("Product1", 23.45, 1),
            Product("Product2", 56.05),
            Product("Product3", 99.99, 1)
    )

    private val items2 = arrayListOf(
            Product("Product11", 23344.45, 1),
            Product("Product22", 56444.05),
            Product("Product33", 992222.99, 2)
    )

    val categories = arrayListOf(
            Category("Category Cheap", 0.0, 0.0, items1),
            Category("Category Expensive", 0.0, 0.0, items2)
    )

    val categoriesLiveData = MutableLiveData<List<Category>>(categories)

    fun incrementProduct(productName: String) {
        val categories = categoriesLiveData.value ?: arrayListOf()
        val category = categories.first { it.name == selectedcategoryName }
        val product = category.products.first { it.name == productName }
        val newCount = (product.count ?: 0) + 1 /* `products.count ?: 0`  pokud count je null tak bude 0*/
        //category.products.remove(product)
        product.count = newCount
        category.totalPrice = calculateTotalPrice(category)
        categoriesLiveData.value = categories
    }

    fun calculateTotalPrice(category: Category): Double {
        var newPrice = 0.0
        category.products.forEach {
            newPrice += (it.count ?: 0) * it.price
        }
        return newPrice
    }

    fun decrementProduct(productName: String) {
        // TODO write method
    }
}