package com.example.hammersystemtest.model

import com.example.hammersystemtest.data.responsenetwork.Data
import retrofit2.Response
import retrofit2.http.GET

interface Network {

    @GET("menu")
    suspend fun getAllProduct(): Response<Data>
}