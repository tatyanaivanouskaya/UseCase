package com.example.usecase.domain.usecase

import com.example.usecase.domain.models.SaveUserName
import com.example.usecase.domain.models.UserName
import com.example.usecase.domain.repository.UserRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.times

class SaveUserNameUseCaseTest {
    private val userRepository = mock<UserRepository>()

    @AfterEach
    fun tearDown(){
        Mockito.reset(userRepository)
    }

    @Test
    fun `should not save data if name is already saved`(){
        val testUserName = UserName(firstName = "test_name", lastName = "test_last_name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val testParam = SaveUserName(name = "test_name")
        val actual = useCase.execute(testParam)
        val expected = true

        Assertions.assertEquals(expected, actual)

        Mockito.verify(userRepository, never()).saveName(saveUserName = any())
    }
    @Test
    fun `should return true if save was successful`(){
        val testUserName = UserName(firstName = "test_name", lastName = "test_last_name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val expected = true

        val testParam = SaveUserName(name = "new_test_name")
        Mockito.`when`(userRepository.saveName(saveUserName = testParam)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute(testParam)

        Assertions.assertEquals(expected, actual)
        Mockito.verify(userRepository, times(1)).saveName(saveUserName = testParam)
    }
    @Test
    fun `should return false if save was successful`(){
        val testUserName = UserName(firstName = "test_name", lastName = "test_last_name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val expected = false

        val testParam = SaveUserName(name = "new_test_name")
        Mockito.`when`(userRepository.saveName(saveUserName = testParam)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute(testParam)

        Assertions.assertEquals(expected, actual)
        Mockito.verify(userRepository, times(1)).saveName(saveUserName = testParam)
    }
}