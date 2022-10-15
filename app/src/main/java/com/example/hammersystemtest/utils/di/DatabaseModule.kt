package com.example.hammersystemtest.utils.di

import android.content.Context
import androidx.room.Room
import com.example.hammersystemtest.model.FoodDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val applicationContext: Context) {

    @Singleton
    @Provides
    fun providerDatabase(): FoodDatabase {
        return Room.databaseBuilder(
            applicationContext,
            FoodDatabase::class.java,
            "transaction_database"
        ).build()
    }

    @Singleton
    @Provides
    fun providerTransactionDao(db: FoodDatabase) = db.foodDao()
}