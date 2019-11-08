package com.example.upeers.msgsearch

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.upeers.R
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.ui.message.MessageUserInfo
import com.example.upeers.ui.message.MessageUserInfoAdapter
import java.util.*


class MsgSearchActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView;
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_msg_search)

//        if (Intent.ACTION_SEARCH == intent.action) {
//        }
//        intent.getStringExtra(SearchManager.QUERY)?.also { query ->
//        }

        doMySearch(SearchManager.QUERY)

        setSupportActionBar(findViewById(R.id.msg_toolbar))
        // up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.msg_search_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    fun doMySearch(query: String) {
        val mydata = listOf<MsgSearchResultInfo>(
            MsgSearchResultInfo(
                "tutor",
                "Alex Bradley",
                true,
                "Alex: Hello!",
                Date(),
                R.drawable.alex,
                listOf("a", "b")
            ),
            MsgSearchResultInfo(
                "tutor",
                "Alex Bradley",
                true,
                "Alex: Hello!",
                Date(),
                R.drawable.alex,
                listOf("a", "b")
            ),
            MsgSearchResultInfo(
                "tutor",
                "Alex Bradley",
                true,
                "Alex: Hello!",
                Date(),
                R.drawable.alex,
                listOf("a", "b")
            ),
            MsgSearchResultInfo(
                "tutor",
                "Alex Bradley",
                true,
                "Alex: Hello!",
                Date(),
                R.drawable.alex,
                listOf("a", "b")
            ),
            MsgSearchResultInfo(
                "tutor",
                "Alex Bradley",
                true,
                "Alex: Hello!",
                Date(),
                R.drawable.alex,
                listOf("a", "b")
            )
        )

        viewManager = LinearLayoutManager(this)
        viewAdapter = MsgSearchResultInfoAdaptor(mydata)

        recyclerView = findViewById<RecyclerView>(R.id.msg_search_recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter

    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.search_view, menu)
//        val searchItem = menu.findItem(R.id.menu_search)
//
//        //通过MenuItem得到SearchView
//        mSearchView = MenuItemCompat.getActionView(searchItem) as SearchView
//
//        return super.onCreateOptionsMenu(menu)
//    }

}
