package com.example.upeers.message

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upeers.R
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.ui.message.MessageUserInfo
import com.example.upeers.ui.message.MessageUserInfoAdapter
import java.util.*

class Message : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView;
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        // toolbar
//        setSupportActionBar(findViewById(R.id.msg_toolbar))
        // Get a support ActionBar corresponding to this toolbar and enable the Up button
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val mydata = listOf<MessageUserInfo>(
            MessageUserInfo(
                "tutor",
                "Alex Bradley",
                true,
                "Alex: Hello!",
                Date(),
                R.drawable.alex
            ),
            MessageUserInfo(
                "tutor",
                "Alex Bradley",
                true,
                "Alex: Hello!",
                Date(),
                R.drawable.alex
            ),
            MessageUserInfo(
                "tutor",
                "Alex Bradley",
                true,
                "Alex: Hello!",
                Date(),
                R.drawable.alex
            ),
            MessageUserInfo(
                "tutor",
                "Alex Bradley",
                true,
                "Alex: Hello!",
                Date(),
                R.drawable.alex
            ),
            MessageUserInfo(
                "tutor",
                "Alex Bradley",
                true,
                "Alex: Hello!",
                Date(),
                R.drawable.alex
            )
        )

        viewManager = LinearLayoutManager(this)
        viewAdapter = MessageUserInfoAdapter(mydata, this)

        recyclerView = findViewById<RecyclerView>(R.id.msg_recycler_view).apply {
            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_search -> {
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView

        // Configure the search info and add any event listeners...

        return super.onCreateOptionsMenu(menu)
    }
}
