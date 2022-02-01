package com.example.usecase.di

import com.example.usecase.domain.usecase.GetUserNameUseCase
import com.example.usecase.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module


val domainModule = module {

    factory<GetUserNameUseCase>{
        GetUserNameUseCase(userRepository = get())
    }
    factory<SaveUserNameUseCase>{
        SaveUserNameUseCase(userRepository = get())
    }
}