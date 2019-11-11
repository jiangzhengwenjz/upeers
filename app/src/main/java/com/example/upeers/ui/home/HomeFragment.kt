package com.example.upeers.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.upeers.R
import com.example.upeers.ui.home.AppDatabase

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerView: RecyclerView;
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        viewManager = LinearLayoutManager(activity)
        viewAdapter = CourseInfoAdapter(homeViewModel.mydata)

        recyclerView = root.findViewById<RecyclerView>(R.id.course_recycler_view).apply {
            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter
        }




//        Adding database here. Commented because we decide not to do it, but I will keep it incase we need it sometime.
//        val db = Room.databaseBuilder(
//            activity!!.applicationContext,
//            AppDatabase::class.java, "database-name"
//        ).build()


        return root
    }
}
