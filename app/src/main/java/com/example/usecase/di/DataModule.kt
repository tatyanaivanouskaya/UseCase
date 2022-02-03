package com.example.usecase.di

import android.content.Context
import com.example.usecase.data.UserRepositoryImpl
import com.example.usecase.data.storage.UserStorage
import com.example.usecase.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.usecase.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataModule {
    @Singleton
    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }
    @Singleton
    @Provides
    fun provideUserRepositoryImpl(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}