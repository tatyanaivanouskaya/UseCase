package com.example.usecase.domain.usecase

import com.example.usecase.domain.models.UserName
import com.example.usecase.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName{
        return userRepository.getName()
    }
}