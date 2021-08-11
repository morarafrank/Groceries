package com.frankmorara.groceries.ui.groceriesadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.frankmorara.groceries.R
import com.frankmorara.groceries.data.Grocery
import com.frankmorara.groceries.ui.fragments.GroceriesListFragmentDirections
import kotlinx.android.synthetic.main.list_item.view.*

class GroceriesListAdapter: RecyclerView.Adapter<GroceriesListAdapter.GroceryViewHolder>(){
    class GroceryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private var groceries = emptyList<Grocery>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        return GroceryViewHolder(LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_item,
            parent, false)
        )
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
       val currentGrocery = groceries[position]
//        holder.itemView.apply {
//            text_item_name.text = currentGrocery.itemName
//            text_item_description.text = currentGrocery.itemDescription
//            text_item_quantity.text = currentGrocery.quantity
//        }
        holder.itemView.apply {
            textview_item_name.text = currentGrocery.itemName
            single_grocery.setOnClickListener {
                val action = GroceriesListFragmentDirections.actionGroceriesListFragmentToGroceriesDetailsFragment()
                holder.itemView.findNavController().navigate(action)
            }
        }


    }

    override fun getItemCount() = groceries.size
    fun setData(grocery: List<Grocery>){
        this.groceries = grocery
        notifyDataSetChanged()
    }

}