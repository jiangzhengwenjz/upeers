package com.example.upeers.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.upeers.R
import com.example.upeers.MainNaviActivity
import android.os.Build
import android.view.Window
import android.transition.Explode
import android.transition.Slide

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // set transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            with(window) {
                requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)

                window.enterTransition = Slide()
                window.exitTransition = Explode()
            }
        }
        setContentView(R.layout.activity_login)
    }

    fun onClickSignIn(view: View) {
        startActivity(Intent(this, MainNaviActivity::class.java).apply {})
    }
}
