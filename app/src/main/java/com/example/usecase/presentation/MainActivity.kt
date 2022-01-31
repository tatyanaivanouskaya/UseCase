package com.example.usecase.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.usecase.R
import com.example.usecase.data.UserRepositoryImpl
import com.example.usecase.data.storage.UserStorage
import com.example.usecase.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.usecase.domain.models.SaveUserName
import com.example.usecase.domain.usecase.GetUserNameUseCase
import com.example.usecase.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userStorage by lazy {SharedPrefUserStorage(context = applicationContext)}
    private val userRepository by lazy { UserRepositoryImpl(userStorage = userStorage)}
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepository)}
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = userRepository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val saveUserName = SaveUserName(name = text)
            val result = saveUserNameUseCase.execute(saveUserName)
            dataTextView.text = "Save result = $result"
        }
        receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}