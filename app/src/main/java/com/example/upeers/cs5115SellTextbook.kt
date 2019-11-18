package com.example.upeers

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.upeers.ui.cs5115SellTextbookConfirm

import kotlinx.android.synthetic.main.activity_cs5115_sell_textbook.*
import android.widget.Toast
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class cs5115SellTextbook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cs5115_sell_textbook)

        Go.setOnClickListener {
            val toast = Toast.makeText(
                applicationContext,
                "You made it!",
                Toast.LENGTH_SHORT
            )
            toast.show()
            finish()
        }


        Cancel.setOnClickListener {
            finish()
        }

    }

}
