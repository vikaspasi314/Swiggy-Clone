package com.example.swiggyclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(
    private val list: MutableList<Food>,
    private val updateTotal: () -> Unit
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.cartName)
        val price: TextView = view.findViewById(R.id.cartPrice)
        val qty: TextView = view.findViewById(R.id.qty)
        val add: Button = view.findViewById(R.id.addBtn)
        val remove: Button = view.findViewById(R.id.removeBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        holder.name.text = item.name
        holder.price.text = "₹${item.price}"
        holder.qty.text = item.quantity.toString()

        holder.add.setOnClickListener {
            item.quantity++
            holder.qty.text = item.quantity.toString()
            updateTotal()
        }

        holder.remove.setOnClickListener {
            item.quantity--

            if (item.quantity <= 0) {
                list.removeAt(position)
                notifyItemRemoved(position)
            } else {
                holder.qty.text = item.quantity.toString()
            }

            updateTotal()
        }
    }
}