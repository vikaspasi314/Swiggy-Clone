package com.example.swiggyclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(
    private val list: List<Food>
) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.foodImage)
        val name: TextView = view.findViewById(R.id.foodName)
        val price: TextView = view.findViewById(R.id.foodPrice)
        val addBtn: Button = view.findViewById(R.id.addBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        holder.image.setImageResource(item.image)
        holder.name.text = item.name
        holder.price.text = "₹${item.price}"

        holder.addBtn.setOnClickListener {
            CartManager.addItem(item)
            holder.addBtn.text = "ADDED"
        }
    }
}