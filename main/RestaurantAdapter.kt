package com.example.swiggyclone

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantAdapter(
    val list: List<Restaurant>
) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.restImage)
        val name: TextView = view.findViewById(R.id.restName)
        val rating: TextView = view.findViewById(R.id.restRating)
        val offer: TextView = view.findViewById(R.id.restOffer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurant_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        holder.image.setImageResource(item.image)
        holder.name.text = item.name
        holder.rating.text = item.rating + " • " + item.time
        holder.offer.text = item.offer

        // CLICK RESTAURANT -> OPEN FOOD SCREEN
        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, FoodActivity::class.java)
            holder.itemView.context.startActivity(intent)

        }
    }
}