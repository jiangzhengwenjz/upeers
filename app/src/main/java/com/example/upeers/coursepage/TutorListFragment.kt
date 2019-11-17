package com.example.upeers.coursepage


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.upeers.R
import com.example.upeers.tutordetail.TutorDetailActivity

/**
 * A simple [Fragment] subclass.
 */
class TutorListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdaptor: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val tutors = listOf<TutorInfo>(
            TutorInfo(R.drawable.alex, "Alex Bradley", "Rate:4.9"),
            TutorInfo(R.drawable.alex, "Yifan Chi", "Rate:4.8"),
            TutorInfo(R.drawable.alex, "Peter Fleck", "Rate:4.7")
        )

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_tutor_list, container, false)

        viewManager = LinearLayoutManager(activity)
        viewAdaptor = TutorListAdaptor(tutors, this.context)

        recyclerView = root.findViewById<RecyclerView>(R.id.tutor_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdaptor
        }

        return root
    }


}
