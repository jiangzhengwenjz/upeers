package com.example.upeers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.textbook_main_screen.*

class TextbookMainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.textbook_main_screen)

        sell.setOnClickListener {
            val intent = Intent(this, cs5115SellTextbook::class.java)
            startActivity(intent)
        }

        buy.setOnClickListener {
            val intent = Intent(this, csci5115BuyTextbook::class.java)
            startActivity(intent)
        }
    }
}
