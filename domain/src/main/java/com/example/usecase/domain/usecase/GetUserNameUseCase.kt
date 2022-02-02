package com.example.usecase.domain.usecase

import com.example.usecase.domain.models.UserName
import com.example.usecase.domain.repository.UserRepository
import javax.inject.Inject

class GetUserNameUseCase @Inject constructor(val userRepository: UserRepository) {

    fun execute(): UserName{
        return userRepository.getName()
    }
}