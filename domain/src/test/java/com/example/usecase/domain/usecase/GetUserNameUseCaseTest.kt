package com.example.usecase.domain.usecase

import com.example.usecase.domain.models.UserName
import com.example.usecase.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetUserNameUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should return the same data as in repository`() {

        val testUserName = UserName(firstName = "test_first_name", lastName = "test_last_name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = GetUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute()
        val expected = UserName(firstName = "test_first_name", lastName = "test_last_name")

        Assertions.assertEquals(expected, actual)
    }
}