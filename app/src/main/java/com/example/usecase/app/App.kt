package com.example.usecase.app

import android.app.Application
import com.example.usecase.di.AppComponent
import com.example.usecase.di.AppModule
import com.example.usecase.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

    }
}