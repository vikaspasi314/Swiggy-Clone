package com.example.swiggyclone

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recycler = view.findViewById<RecyclerView>(R.id.restaurantRecycler)

        val list = listOf(
            Restaurant("Dominos Pizza", "4.3", "30 mins", R.drawable.pizza, "50% OFF"),
            Restaurant("Burger King", "4.1", "25 mins", R.drawable.burger, "40% OFF"),
            Restaurant("Biryani House", "4.5", "35 mins", R.drawable.biryani, "60% OFF"),
            Restaurant("KFC", "4.2", "28 mins", R.drawable.kfc, "Free Delivery")
        )

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = RestaurantAdapter(list)

        return view
    }
}