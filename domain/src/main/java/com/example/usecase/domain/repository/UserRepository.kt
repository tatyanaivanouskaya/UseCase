package com.example.usecase.domain.repository

import com.example.usecase.domain.models.SaveUserName
import com.example.usecase.domain.models.UserName

interface UserRepository {

    fun saveName(saveUserName: SaveUserName):Boolean

    fun getName(): UserName
}