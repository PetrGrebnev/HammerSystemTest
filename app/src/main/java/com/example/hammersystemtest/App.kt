package com.example.hammersystemtest

import android.app.Application
import com.example.hammersystemtest.utils.di.AppComponent
import com.example.hammersystemtest.utils.di.AppModule
import com.example.hammersystemtest.utils.di.DaggerAppComponent
import com.example.hammersystemtest.utils.di.DatabaseModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .databaseModule(DatabaseModule(this))
            .build()
    }

    companion object{
        lateinit var appComponent: AppComponent
    }
}