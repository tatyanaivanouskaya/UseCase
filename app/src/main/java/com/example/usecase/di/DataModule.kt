package com.example.usecase.di

import android.content.Context
import com.example.usecase.data.UserRepositoryImpl
import com.example.usecase.data.storage.UserStorage
import com.example.usecase.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.usecase.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage{
        return SharedPrefUserStorage(context = context)
    }
}