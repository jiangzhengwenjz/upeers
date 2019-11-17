package com.example.upeers

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_cs5115_textbook1_details.*

class cs5115Textbook1Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cs5115_textbook1_details)

        back.setOnClickListener {
            val intent = Intent(this, csci5115Textbook1Buy::class.java)
            startActivity(intent)
        }
    }

}
