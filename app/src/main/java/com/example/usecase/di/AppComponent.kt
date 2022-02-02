package com.example.usecase.di

import com.example.usecase.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}