package com.example.upeers.tutordetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.upeers.R

class TutorDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor_detail)

        val imageView : ImageView = findViewById(R.id.tutor_avatar)
        imageView.setImageResource(R.drawable.alex)
    }
}
