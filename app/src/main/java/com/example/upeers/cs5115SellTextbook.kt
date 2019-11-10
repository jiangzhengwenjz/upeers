package com.example.upeers

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_cs5115_sell_textbook.*

class cs5115SellTextbook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cs5115_sell_textbook)

        addAnother.setOnClickListener {
            val intent = Intent(this, cs5115SellTextbook::class.java)
            startActivity(intent)
        }

        Cancel.setOnClickListener {
            val intent = Intent(this, TextbookMainActivity::class.java)
            startActivity(intent)
        }

        upload.setOnClickListener {
            val intent = Intent(this, TextbookMainActivity::class.java)
            startActivity(intent)
        }

    }

}
