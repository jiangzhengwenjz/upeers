package com.example.upeers

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_cs5115_textbook_wishlist.*

class cs5115TextbookWishlist : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cs5115_textbook_wishlist)

        back.setOnClickListener {
            val intent = Intent(this, cs5115Textbook1Details::class.java)
            startActivity(intent)
        }
    }



}
