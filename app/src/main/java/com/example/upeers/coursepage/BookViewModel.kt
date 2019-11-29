package com.example.upeers.coursepage

import androidx.lifecycle.ViewModel
import com.example.upeers.R

class BookViewModel : ViewModel() {

    companion object {
        var mydata: MutableList<BookInfo> = mutableListOf<BookInfo>(
            BookInfo(
                "27",
                "Keller Hall",
                "Almost brand new book without any mark",
                R.drawable.book_example4,
                R.drawable.book_example2,
                5),
            BookInfo("28",
                "Stadium Village",
                "Perfect condition with a little note on pages",
                R.drawable.book_example3,
                R.drawable.book_example1,
                7),
            BookInfo("35",
                "Northrop",
                "My book looks like a new one",
                R.drawable.book_example2,
                R.drawable.book_example4,
                0)
        )
    }

    fun getMyData(): List<BookInfo> {
        return mydata
    }
    fun changeData(bookInfo: BookInfo) {
        mydata.add(bookInfo)
    }
    fun sortDataByPrice() {
        mydata.sortBy({it.price})
    }
    fun sortDataByCount() {
        mydata.sortBy({it.viewCount})
    }
    fun sortDataByDistance() {
        mydata.sortBy({it.location})
    }
}