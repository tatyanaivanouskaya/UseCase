package com.example.usecase.domain.usecase


import com.example.usecase.domain.models.SaveUserName
import com.example.usecase.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserNameUseCase @Inject constructor(val userRepository: UserRepository){

    fun execute(param: SaveUserName): Boolean {
        return userRepository.saveName(param)
    }
}