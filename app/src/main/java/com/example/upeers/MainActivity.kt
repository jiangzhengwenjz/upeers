package com.example.upeers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.upeers.message.Message

const val EXTRA_MSG = "com.example.message.Message"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickTemporaryButton(view: View) {
        val intent = Intent(this, MainNaviActivity::class.java).apply {
        }
        startActivity(intent)
    }
  
    fun goToMessage(view: View) {
        val intent = Intent(this, Message::class.java).apply {

        }
        startActivity(intent)
    }

}
