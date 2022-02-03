package com.example.usecase.data

import com.example.usecase.data.storage.models.User
import com.example.usecase.data.storage.UserStorage
import com.example.usecase.domain.models.SaveUserName
import com.example.usecase.domain.models.UserName
import com.example.usecase.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {


    override fun saveName(saveUserName: SaveUserName): Boolean {
        return userStorage.save(user = mapToStorage(saveUserName))
    }

    override fun getName(): UserName {
        return mapToDomain(userStorage.get())

    }
    private fun mapToDomain(user: User): UserName{
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
    private fun mapToStorage(saveUserName: SaveUserName):User{
        return User(firstName = saveUserName.name, lastName = "def_last_name")
    }
}