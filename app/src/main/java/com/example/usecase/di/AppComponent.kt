package com.example.usecase.di

import com.example.usecase.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}