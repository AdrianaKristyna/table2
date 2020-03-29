package com.example.table2.model

data class Product(
        val name: String,
        val price: Double,
        var count: Int? = null /* pokud nic nezadas tak nude null */
)