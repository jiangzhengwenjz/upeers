package com.example.upeers.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.upeers.R
import com.example.upeers.TextbookMainActivity
import com.example.upeers.cs5115SellTextbook
import kotlinx.android.synthetic.main.activity_cs5115_sell_textbook.*
import kotlinx.android.synthetic.main.activity_cs5115selltextbookconfirm.*

class cs5115SellTextbookConfirm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cs5115selltextbookconfirm)
        addAnother.setOnClickListener {
            val intent = Intent(this, cs5115SellTextbook::class.java)
            startActivity(intent)
        }

        Cancel2.setOnClickListener {
            val intent = Intent(this, TextbookMainActivity::class.java)
            startActivity(intent)
        }

        upload.setOnClickListener {
            val intent = Intent(this, TextbookMainActivity::class.java)
            startActivity(intent)
        }

        Notmybook.setOnClickListener {
            val intent = Intent(this, cs5115SellTextbook::class.java)
            startActivity(intent)
        }
    }
}
