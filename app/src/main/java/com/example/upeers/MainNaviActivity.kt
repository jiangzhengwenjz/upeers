package com.example.upeers

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.upeers.msglist.MessageListActivity
import com.example.upeers.msgsearch.MsgSearchActivity

class MainNaviActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navi)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        // toolbar
        setSupportActionBar(findViewById(R.id.msg_toolbar))
        // Get a support ActionBar corresponding to this toolbar and enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_message, R.id.navigation_account
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // // my_child_toolbar is defined in the layout file
        // setSupportActionBar(findViewById(R.id.msg_toolbar))

        // // Get a support ActionBar corresponding to this toolbar and enable the Up button
        // supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_search -> {
            val intent = Intent(this, MsgSearchActivity::class.java).apply {
            }
            startActivity(intent)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    // override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    //     menuInflater.inflate(R.menu.toolbar_menu, menu)
    //     val searchItem = menu?.findItem(R.id.action_search)
    //     val searchView = searchItem?.actionView as SearchView

    //     // Configure the search info and add any event listeners...

//        return super.onCreateOptionsMenu(menu)
//    }

    fun onClickMsgUserCard(view: View) {
        val intent = Intent(this, MessageListActivity::class.java).apply {
            // should use putExtra here I guess
//                val remoteUserName = it.username.text
        }
        startActivity(intent)
    }
}
