package com.example.upeers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_csci5115_textbook1_buy.*

class csci5115Textbook1Buy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_csci5115_textbook1_buy)

        viewPictures.setOnClickListener {
            val intent = Intent(this, cs5115Textbook1Details::class.java)
            startActivity(intent)
        }

        back.setOnClickListener {
            val intent = Intent(this, csci5115BuyTextbook::class.java)
            startActivity(intent)
        }
    }

}
