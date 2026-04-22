package com.example.swiggyclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val recycler = findViewById<RecyclerView>(R.id.foodRecycler)

        val list = listOf(
            Food("Burger",120,R.drawable.burger),
            Food("Pizza",250,R.drawable.pizza),
            Food("Biryani",180,R.drawable.biryani)
        )

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = FoodAdapter(list)
    }
}