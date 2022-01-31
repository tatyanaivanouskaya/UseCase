package com.example.usecase.data.storage

import com.example.usecase.data.storage.models.User


interface UserStorage {

    fun save(user: User):Boolean

    fun get(): User

}