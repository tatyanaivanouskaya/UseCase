package com.example.usecase.di

import android.content.Context
import com.example.usecase.data.UserRepositoryImpl
import com.example.usecase.data.storage.UserStorage
import com.example.usecase.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.usecase.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }
    @Provides
    fun provideUserRepositoryImpl(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}