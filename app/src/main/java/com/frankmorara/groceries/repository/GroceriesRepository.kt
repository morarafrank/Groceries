package com.frankmorara.groceries.repository

import androidx.lifecycle.LiveData
import com.frankmorara.groceries.data.Grocery
import com.frankmorara.groceries.data.GroceryDao

class GroceriesRepository(private val groceryDao: GroceryDao) {

    val selectAllGroceries: LiveData<List<Grocery>> = groceryDao.selectAllGroceries()

    fun addGrocery(grocery: Grocery){
        groceryDao.addGrocery(grocery)
    }

}