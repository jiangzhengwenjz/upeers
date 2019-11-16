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
import com.example.upeers.coursepage.CoursePageActivity
import com.example.upeers.msglist.MessageListActivity
import com.example.upeers.msgsearch.MsgSearchActivity
import com.example.upeers.ui.home.AddCourseActivity
import com.example.upeers.ui.home.CourseInfoAdapter
import com.example.upeers.ui.home.HomeFragment
import com.example.upeers.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_main_navi.*

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

    fun onClickMsgUserCard(view: View) {
        val intent = Intent(this, MessageListActivity::class.java).apply {
//            should use putExtra here I guess
        }
        startActivity(intent)
    }

    fun onClickCourseList(view: View) {
        val intent = Intent (this, CoursePageActivity::class.java).apply {}
        startActivity(intent)
    }

    //"add" button. Add a course (namely 5115).
    fun onClickAddCourse(view: View) {
        val hvm = HomeViewModel()
        hvm.changeData()
        val intent = Intent (this, AddCourseActivity::class.java).apply {}
        startActivity(intent)

//        TODO: should auto-refresh the recycler view here.
//        Something like navHostFragment.getChildFragmentManager().getFragments().get(0);
    }
}
