package com.frankmorara.groceries.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grocery_data")
data class Grocery (
    @PrimaryKey val id: Int,
    val itemName: String,
    val itemDescription: String,
    val Amount: Double

        )