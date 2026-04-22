package com.example.swiggyclone

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartFragment : Fragment() {

    private lateinit var adapter: CartAdapter
    private lateinit var total: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        val recycler = view.findViewById<RecyclerView>(R.id.cartRecycler)
        total = view.findViewById(R.id.cartTotal)
        val checkout = view.findViewById<Button>(R.id.checkoutBtn)

        adapter = CartAdapter(CartManager.cartList) {
            updateTotal()
        }

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        updateTotal()

        checkout.setOnClickListener {
            startActivity(Intent(requireContext(), OrderPlacedActivity::class.java))
        }

        return view
    }

    override fun onResume() {
        super.onResume()

        // refresh after returning
        adapter.notifyDataSetChanged()
        updateTotal()
    }

    private fun updateTotal() {
        total.text = "Total ₹${CartManager.getTotal()}"
    }
}