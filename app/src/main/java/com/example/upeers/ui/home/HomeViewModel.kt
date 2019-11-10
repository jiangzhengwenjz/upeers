package com.example.upeers.ui.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val mydata = listOf<CourseInfo> (
        CourseInfo(
            "CSCI", 5115,
            "Loren Terveen",
            2019, true, "Intro to UI design"
        ),
        CourseInfo(
            "GRAD", 5102,
            "Mary",
            2019, true, "Speaking English for Non-native"
        ),
        CourseInfo(
            "CSCI", 5115,
            "Lana Yarosh",
            2020, false, "Intro to UI design"
        ),
        CourseInfo(
            "CSCI", 5103,
            "Abhishek Chandra",
            2020, false, "Operating Systems"
        ),
        CourseInfo(
            "CSCI", 5105,
            "Jon B Weissman",
            2020, false, "Intro to distributed systems"
        )
    )
}
