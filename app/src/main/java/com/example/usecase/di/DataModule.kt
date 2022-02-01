package com.example.usecase.di

import com.example.usecase.data.UserRepositoryImpl
import com.example.usecase.data.storage.UserStorage
import com.example.usecase.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.usecase.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage>{
        SharedPrefUserStorage(context = get())
    }
    single<UserRepository>{
        UserRepositoryImpl(userStorage =get())
    }
}