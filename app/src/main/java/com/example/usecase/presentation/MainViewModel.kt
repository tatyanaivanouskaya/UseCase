package com.example.usecase.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usecase.domain.models.SaveUserName
import com.example.usecase.domain.usecase.GetUserNameUseCase
import com.example.usecase.domain.usecase.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val getUserNameUseCase: GetUserNameUseCase, val saveUserNameUseCase: SaveUserNameUseCase
        ): ViewModel(){

    private val resultDataMutable = MutableLiveData<String>()
    val resultData: LiveData<String> = resultDataMutable

    fun save(text: String){
        val saveUserName = SaveUserName(name = text)
        val result = saveUserNameUseCase.execute(saveUserName)
        resultDataMutable.value = "Save result = $result"

    }

    fun load(){
        val userName = getUserNameUseCase.execute()
        resultDataMutable.value = "${userName.firstName} ${userName.lastName}"

    }
}