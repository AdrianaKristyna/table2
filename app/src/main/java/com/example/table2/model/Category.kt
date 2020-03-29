package com.example.table2.model

data class Category(
        val name: String,
        val pricePerItem: Double, /* nevim co to znamena */
        var totalPrice: Double, /* tohle chapu jako cenu vsech produktu */
        val products: ArrayList<Product> = arrayListOf()
)