package com.example.swiggyclone

data class Food(
    val name: String,
    val price: Int,
    val image: Int,
    var quantity: Int = 1
)