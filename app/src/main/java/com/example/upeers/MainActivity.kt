package com.example.upeers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
<<<<<<< HEAD
import com.example.upeers.message.Message
import com.example.upeers.msglist.MessageListActivity

const val EXTRA_MSG = "com.example.message.Message"
=======
>>>>>>> origin/master

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
<<<<<<< HEAD
  
    fun goToMessage(view: View) {
        val intent = Intent(this, Message::class.java).apply {

        }
        startActivity(intent)
    }


=======
>>>>>>> origin/master
}
