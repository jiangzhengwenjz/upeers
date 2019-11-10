package com.example.upeers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.upeers.ui.login.LoginActivity
import com.example.upeers.ui.login.RegisterActivity
import com.example.upeers.msglist.MessageListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickSignIn(view: View) {
        startActivity(Intent(this, LoginActivity::class.java).apply {})
    }

    fun onClickSignUp(view: View) {
        startActivity(Intent(this, RegisterActivity::class.java).apply {})
    }


}
