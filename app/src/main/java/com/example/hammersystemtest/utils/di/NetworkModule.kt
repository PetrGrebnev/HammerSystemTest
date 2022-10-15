package com.example.hammersystemtest.utils.di

import android.util.Log
import com.example.hammersystemtest.model.Network
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URl = "https://foodbukka.herokuapp.com/api/v1/"

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providerJson(): Network {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URl)
            .client(getOkHttpClient())
            .build()
        return retrofit.create(Network::class.java)
    }

    private fun getOkHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor { message ->
                    Log.d("OK HTTP", message)
                }.apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
}