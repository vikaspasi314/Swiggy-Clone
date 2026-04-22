package com.example.swiggyclone

object CartManager {

    val cartList = mutableListOf<Food>()

    fun addItem(food: Food) {
        cartList.add(food)
    }

    fun removeItem(food: Food) {
        cartList.remove(food)
    }

    fun getTotal(): Int {
        return cartList.sumOf { it.price }
    }
}