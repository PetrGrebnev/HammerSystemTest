package com.example.hammersystemtest.utils.di

import com.example.hammersystemtest.ui.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [NetworkModule::class, AppModule::class, DatabaseModule::class])
interface AppComponent {

    fun inject(fragment: HomeFragment)
}