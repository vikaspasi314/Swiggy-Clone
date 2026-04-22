package com.example.swiggyclone

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchFragment : Fragment() {

    private val allItems = listOf(
        "Burger",
        "Pizza",
        "Biryani",
        "Fried Rice",
        "McDonald's",
        "Dominos",
        "KFC",
        "Sandwich",
        "Paneer Tikka",
        "Rolls"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_search, container, false)

        val search = view.findViewById<EditText>(R.id.searchBox)
        val recycler = view.findViewById<RecyclerView>(R.id.searchRecycler)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = SearchAdapter(allItems)

        search.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {

                val filtered = allItems.filter {
                    it.lowercase().contains(text.toString().lowercase())
                }

                recycler.adapter = SearchAdapter(filtered)
            }
        })

        return view
    }
}