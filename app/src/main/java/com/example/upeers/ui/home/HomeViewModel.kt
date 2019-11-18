package com.example.upeers.ui.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    companion object {
        var mydata = listOf<CourseInfo>(
            CourseInfo(
                "CSCI 5115",
                "Loren Terveen",
                "FALL2019",
                "User Interface Design, Implementation and Evaluation",
                "33 book copies currently on sale\n2 tutors available at this time",
                "How do we make user test plan?\nMeeting some problem with android's fragments. Any help?",
                "8 replies - 22 mins ago\n1 reply - 7 mins ago"
            )
        )
    }

    fun getMyData(): List<CourseInfo> {
        return mydata
    }
    fun changeData() {
        mydata = listOf<CourseInfo>(
            CourseInfo(
                "CSCI 8980",
                "Undecided",
                "SPRING2020",
                "Advanced\nUI design",
                "2 book copies currently on sale\n0 tutors available at this time",
                "Is there anyone choosing this class?\nAnyone knows who will be the teacher of the course?",
                "3 replies - 5 mins ago\n0 reply - 1 hr ago"
            ),
            CourseInfo(
                "CSCI 5115",
                "Loren Terveen",
                "FALL2019",
                "User Interface Design, Implementation and Evaluation",
                "33 book copies currently on sale\n2 tutors available at this time",
                "How do we make user test plan?\nMeeting some problem with android's fragments. Any help?",
                "8 replies - 22 mins ago\n1 reply - 7 mins ago"
            )
        )
    }
}

