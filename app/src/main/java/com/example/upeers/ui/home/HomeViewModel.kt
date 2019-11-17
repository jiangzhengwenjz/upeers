package com.example.upeers.ui.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    companion object {
        var mydata = listOf<CourseInfo>(
            CourseInfo(
                "CSCI 5115",
                "Loren Terveen",
                "FALL2019",
                "Introduction to User Interface design",
                "33 book copies currently on sale\n2 tutors available at this time",
                "How do we make user test plan?\nMeeting some problem with android's fragments. Any help?",
                "8 replies - 22mins ago\n1 reply - 7mins ago"
            )
        )
    }

    fun getMyData(): List<CourseInfo> {
        return mydata
    }
    fun changeData() {
        mydata = listOf<CourseInfo>(
            CourseInfo(
                "CSCI 5115",
                "Loren Terveen",
                "SPRING2020",
                "Intro to UI design",
                "33 book copies currently on sale\n2 tutors available at this time",
                "How do we make user test plan?\nMeeting some problem with android's fragments. Any help?",
                "8 replies - 22mins ago\n1 reply - 7mins ago"
            )



        )
    }
}

