package com.example.upeers

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_cs5115_sell_textbook.*
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.upeers.coursepage.BookInfo
import com.example.upeers.coursepage.BookViewModel


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

            //initialize the book view model, and add the data using that func.
            var bookViewModel : BookViewModel =
                ViewModelProviders.of(this).get(BookViewModel::class.java)

            val price = findViewById<EditText>(R.id.price)
            val location = findViewById<EditText>(R.id.edition)
            val book_condition = findViewById<EditText>(R.id.condition)
            val _price = price.text.toString()
            val _location = location.text.toString()
            val _book_condition = book_condition.text.toString()

            val bookInfo = BookInfo(_price,
                _location,
                _book_condition,
                R.drawable.book_example3,
                R.drawable.book_example1,
                7)
            bookViewModel.changeData(bookInfo);



            finish()
        }


        Cancel.setOnClickListener {
            finish()
        }

    }

}
