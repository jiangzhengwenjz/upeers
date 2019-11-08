package com.example.upeers.ui.message

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.upeers.R
import java.util.*

class MessageViewModel : ViewModel() {

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
