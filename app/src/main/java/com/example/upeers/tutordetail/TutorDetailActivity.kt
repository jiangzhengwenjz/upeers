package com.example.upeers.tutordetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.upeers.R
import com.example.upeers.msglist.MessageListActivity

class TutorDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor_detail)

        val imageView : ImageView = findViewById(R.id.tutor_avatar)
        imageView.setImageResource(R.drawable.alex)
    }

    fun onClickStartChatting(view: View) {
        val intent = Intent(this, MessageListActivity::class.java).apply {
            // should use putExtra here I guess
        }
        startActivity(intent)
    }
}
