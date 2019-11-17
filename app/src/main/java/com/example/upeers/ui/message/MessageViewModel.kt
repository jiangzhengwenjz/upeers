package com.example.upeers.ui.message

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.upeers.R
import java.util.*

class MessageViewModel : ViewModel() {

    val mydata = listOf<MessageUserInfo>(
        MessageUserInfo(
            "Tutor-CSCI5115",
            "Alex Bradley",
            true,
            "Alex: Hello!",
            Date(),
            R.drawable.alex
        ),
        MessageUserInfo(
            "Tutor-CSCI5521",
            "Yifan Chi",
            true,
            "You: I wonder how ...",
            Date(),
            R.drawable.yifan
        ),
        MessageUserInfo(
            "Tutor-CSCI5619",
            "Peter Fleck",
            true,
            "Fleck: I think you can ...",
            Date(),
            R.drawable.fleck
        )
    )
}
