package com.example.usecase.di

import com.example.usecase.domain.repository.UserRepository
import com.example.usecase.domain.usecase.GetUserNameUseCase
import com.example.usecase.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase{
        return GetUserNameUseCase(userRepository = userRepository)
    }
    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase{
        return SaveUserNameUseCase(userRepository = userRepository)
    }
}