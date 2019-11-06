package com.example.upeers.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "The course list is currently empty. Press \"+\" button to add a course."
//    }
//    val text: LiveData<String> = _text

    val mydata = listOf<CourseItem> (
        CourseItem(
            "CSCI", 5115,
            "Loren Terveen",
            2019, true, "Intro to UI design"
        ),
        CourseItem(
            "GRAD", 5102,
            "Mary",
            2019, true, "Speaking English for Non-native"
        ),
        CourseItem(
            "CSCI", 5115,
            "Lana Yarosh",
            2020, false, "Intro to UI design"
        ),
        CourseItem(
            "CSCI", 5103,
            "Abhishek Chandra",
            2020, false, "Operating Systems"
        ),
        CourseItem(
            "CSCI", 5105,
            "Jon B Weissman",
            2020, false, "Intro to distributed systems"
        )
    )
}