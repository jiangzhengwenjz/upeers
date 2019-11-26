package com.example.upeers.myselling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.upeers.R


class MySellingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_selling)
        val image1 : ImageView = findViewById(R.id.book_img_1)
        val image2 : ImageView = findViewById(R.id.book_img_2)
        image1.setImageResource(R.drawable.book_example1)
        image2.setImageResource(R.drawable.book_example2)
    }
}
