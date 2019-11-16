package com.example.upeers.ui.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    companion object {
        var mydata = listOf<CourseInfo>(
            CourseInfo(
                "CSCI", 5115,
                "Loren Terveen",
                2019, true, "Intro to UI design"
            )
        )
    }

    fun getMyData(): List<CourseInfo> {
        return mydata
    }
    fun changeData() {
        mydata = listOf<CourseInfo>(
            CourseInfo(
                "CSCI", 5115,
                "Loren Terveen",
                2019, true, "Intro to UI design"
            ),
            CourseInfo(
                "CSCI", 5115,
                "Lana Yarosh",
                2020, false, "Intro to UI design 2"
            )
        )
    }
}

