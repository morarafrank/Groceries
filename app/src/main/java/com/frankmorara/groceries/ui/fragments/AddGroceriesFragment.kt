package com.frankmorara.groceries.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.frankmorara.groceries.R
import com.frankmorara.groceries.data.Grocery
import com.frankmorara.groceries.viewmodel.GroceriesViewModel
import kotlinx.android.synthetic.main.fragment_groceries_details.*
import kotlinx.android.synthetic.main.fragment_groceries_details.view.*

class AddGroceriesFragment: Fragment(R.layout.fragment_groceries_details) {
    private lateinit var groceryViewModel: GroceriesViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_groceries_details, container, false)

        groceryViewModel = ViewModelProvider(this).get(GroceriesViewModel::class.java)
        view.button.setOnClickListener {
            addGroceriesToDatabase()
        }

        return view
    }

    private fun addGroceriesToDatabase() {
        val itemName = text_item_name.text.toString()
        val description = text_item_description.text.toString()
        val quantity = text_item_quantity.text

        if (inputCheck(itemName, description, quantity)){
            val grocery = Grocery(0,itemName,description, quantity.toString().toDouble())
            groceryViewModel.addGrocery(grocery)
            Toast.makeText(requireContext(), "Added ${grocery.itemName} to database",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_groceriesDetailsFragment_to_groceriesListFragment)
        }else{
            Toast.makeText(requireContext(), "Fill Out all fields", Toast.LENGTH_SHORT).show()
        }

    }
    private fun inputCheck(itemName: String, description: String, quantinty: Editable): Boolean{
        return !(TextUtils.isEmpty(itemName) && TextUtils.isEmpty(description) && TextUtils.isEmpty(quantinty.toString()))
    }
}