package com.example.upeers.coursepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.upeers.R

class SellNewBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.unused_activity_sell_new_book)
        setTitle("Sell: Add book")
    }

    fun onClickAddBook(view: View){
        finish()
    }
}
