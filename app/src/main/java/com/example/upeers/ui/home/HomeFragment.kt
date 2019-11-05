package com.example.upeers.ui.home

import android.os.Bundle
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.MainNaviActivity
import com.example.upeers.R
import kotlinx.android.synthetic.main.activity_main_navi.*

class HomeFragment : Fragment() {

    //initialize the view model.
//    private lateinit var homeViewModel: HomeViewModel
    private lateinit var courseListView: RecyclerView
    private lateinit var courseListViewAdapter: RecyclerView.Adapter<*>
    private lateinit var courseListViewManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        courseListViewManager = LinearLayoutManager(this.context)
//        courseListViewAdapter = MyAdapter(myDataset)
//        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)



        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)

//        homeViewModel.text.observe(this, Observer {
//            textView.text = it
//        })

//        courseListView = root.findViewById<RecyclerView>(R.id.course_list_view).apply {
//            layoutManager = courseListViewManager
//            adapter = courseListViewAdapter
//        }



        return root
    }
}
//
//class MyAdapter(private val myDataset: list<CourseInfo>):
//        RecyclerView.Adapter<MyAdapter.CourseInfoViewHolder> () {
//
//    class CourseInfoViewHolder(val userInfoView: View)  : RecyclerView.ViewHolder(userInfoView) {
//        val label: TextView = userInfoView.findViewById(R.id.label)
//        val username: TextView = userInfoView.findViewById(R.id.username)
//    }
//
//
//    //TODO: 1. implement the things below. 2. add some xml files to make this recycler view seems better
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseInfoViewHolder {
//        val cardView = LayoutInflater.from(parent.context)
//            .inflate(R.layout.layout_message_contact_card, parent, false) as View
//
//        return  MessageUserInfoViewHolder(cardView)
//    }
//
//    override fun onBindViewHolder(holder: MessageUserInfoViewHolder, position: Int) {
//        holder.label.text = myDataSet[position].label
//        holder.username.text = myDataSet[position].name
//        holder.active.text = if (myDataSet[position].active) {
//            "active"
//        } else {
//            "away"
//        }
//        holder.lastMessage.text = myDataSet[position].lastMsg
//        // need to set image here
//    }

//}
