package com.example.usecase.domain.usecase


import com.example.usecase.domain.models.SaveUserName
import com.example.usecase.domain.repository.UserRepository

class SaveUserNameUseCase (private val userRepository: UserRepository){

    fun execute(param: SaveUserName): Boolean{
        val result = userRepository.saveName(param)
        return result
    }
}