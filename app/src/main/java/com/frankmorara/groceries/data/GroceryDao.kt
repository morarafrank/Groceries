package com.frankmorara.groceries.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface GroceryDao {
    @Insert
    fun addGrocery(grocery: Grocery)

    @Query("select * from grocery_data order by id asc")
    fun selectAllGroceries(): LiveData<List<Grocery>>
}