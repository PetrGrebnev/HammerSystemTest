package com.example.hammersystemtest.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_food")
data class Food(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "image") val images: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "price") val price: String
)
