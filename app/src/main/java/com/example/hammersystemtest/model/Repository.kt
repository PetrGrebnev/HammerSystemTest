package com.example.hammersystemtest.model

import com.example.hammersystemtest.data.database.Food
import com.example.hammersystemtest.data.responsenetwork.DataResult
import javax.inject.Inject

class Repository @Inject constructor(
    private val network: Network,
    private val dao: FoodDao
) {

    suspend fun getAllProduct() = network.getAllProduct()

    suspend fun setSaveData(food: List<Food>) {
        dao.setSaveData(food)
    }

    suspend fun getAllProductDatabase() = dao.getFood()

    fun mapper(data: DataResult) = Food(
        id = 0,
        title = data.menuname,
        description = data.description,
        price = data.__v,
        images = data.images[0]
    )

    fun cleanDatabase() {
        dao.clean()
    }
}