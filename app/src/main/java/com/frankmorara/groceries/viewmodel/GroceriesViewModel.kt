package com.frankmorara.groceries.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.frankmorara.groceries.data.Grocery
import com.frankmorara.groceries.data.GroceryDatabase
import com.frankmorara.groceries.repository.GroceriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroceriesViewModel(application: Application): AndroidViewModel(application) {
    val selectAllGroceries: LiveData<List<Grocery>>
    private val repository: GroceriesRepository

    init {
        val groceryDao = GroceryDatabase.getDatabase(application).groceryDao()
        repository = GroceriesRepository(groceryDao)
        selectAllGroceries = repository.selectAllGroceries
    }

    fun addGrocery(grocery: Grocery){
        viewModelScope.launch(Dispatchers.IO){
            repository.addGrocery(grocery)
        }
    }
}