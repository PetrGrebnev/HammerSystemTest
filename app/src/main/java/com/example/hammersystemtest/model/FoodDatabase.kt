package com.example.hammersystemtest.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hammersystemtest.data.database.Food

@Database(
    entities = [Food::class],
    version = 1,
    exportSchema = false
)
abstract class FoodDatabase: RoomDatabase(){
    abstract fun foodDao() : FoodDao
}