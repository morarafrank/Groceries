package com.frankmorara.groceries.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.frankmorara.groceries.R
import com.frankmorara.groceries.ui.groceriesadapter.GroceriesListAdapter
import kotlinx.android.synthetic.main.fragment_groceries_list.view.*

class GroceriesListFragment: Fragment(R.layout.fragment_groceries_list) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_groceries_list, container, false)

        val adapter = GroceriesListAdapter()
        val recyclerView = view.recycler_view
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        view.floatingActionButton.setOnClickListener {
            val action = GroceriesListFragmentDirections.actionGroceriesListFragmentToGroceriesDetailsFragment()
            findNavController().navigate(action)
        }
        return view
    }
}