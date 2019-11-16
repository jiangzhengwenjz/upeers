package com.example.upeers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_textbook__buying.*

class csci5115BuyTextbook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textbook__buying)


        addToWishlist.setOnClickListener {
            val intent = Intent(this, cs5115TextbookWishlist::class.java)
            startActivity(intent)
        }

        buy.setOnClickListener {
            val intent = Intent (this, csci5115Textbook1Buy::class.java)
            startActivity(intent)
        }
    }

}
