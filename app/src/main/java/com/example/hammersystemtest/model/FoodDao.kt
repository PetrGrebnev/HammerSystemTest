package com.example.hammersystemtest.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hammersystemtest.data.database.Food

@Dao
interface FoodDao {

    @Insert
    fun setSaveData(food: List<Food>)

    @Query("SELECT * FROM list_food")
    fun getFood(): List<Food>

    @Query("DELETE FROM list_food")
    fun clean()
}
