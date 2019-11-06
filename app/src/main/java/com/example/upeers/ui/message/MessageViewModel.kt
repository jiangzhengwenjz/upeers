package com.example.upeers.ui.message

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.upeers.R
import java.util.*

class MessageViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is message Fragment"
    }
    val text: LiveData<String> = _text

    val mydata = listOf<MessageUserInfo>(
        MessageUserInfo(
            "tutor",
            "Alex Bradley",
            true,
            "Alex: Hello!",
            Date(),
            R.drawable.alex
        ),
        MessageUserInfo(
            "tutor",
            "Alex Bradley",
            true,
            "Alex: Hello!",
            Date(),
            R.drawable.alex
        ),
        MessageUserInfo(
            "tutor",
            "Alex Bradley",
            true,
            "Alex: Hello!",
            Date(),
            R.drawable.alex
        ),
        MessageUserInfo(
            "tutor",
            "Alex Bradley",
            true,
            "Alex: Hello!",
            Date(),
            R.drawable.alex
        ),
        MessageUserInfo(
            "tutor",
            "Alex Bradley",
            true,
            "Alex: Hello!",
            Date(),
            R.drawable.alex
        )
    )
}