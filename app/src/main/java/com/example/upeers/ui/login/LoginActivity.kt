package com.example.upeers.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.upeers.R
import com.example.upeers.MainNaviActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onClickSignIn(view: View) {
        startActivity(Intent(this, MainNaviActivity::class.java).apply {})
    }
}
