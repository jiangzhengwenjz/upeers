package com.example.upeers.coursepage


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.upeers.R
import com.example.upeers.cs5115TextbookWishlist
import com.example.upeers.ui.home.AddCourseActivity



/**
 * A simple [Fragment] subclass.
 */
class BookFragment : Fragment() {

    private lateinit var bookViewModel: BookViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdaptor: BookListAdaptor
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bookViewModel =
            ViewModelProviders.of(this).get(BookViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_book, container, false)
        val bookStdImg: ImageView = root.findViewById(R.id.book_std_img)
        bookStdImg.setImageResource(R.drawable.tanasescu3d)

        viewManager = LinearLayoutManager(activity)
        viewAdaptor = BookListAdaptor(bookViewModel.getMyData(), context)

        recyclerView = root.findViewById<RecyclerView>(R.id.books_list).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdaptor
        }

        // spinner listener
        val spinner = root.findViewById<Spinner>(R.id.sort_options)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val idInt = id.toInt()
                if (idInt == 0) {
                    bookViewModel.sortDataByPrice();
                } else if (idInt == 1) {
                    bookViewModel.sortDataByCount();
                } else if (idInt == 2) {
                    bookViewModel.sortDataByDistance();
                }
                notifyViewAdaptor()
            }
        }
        return root
    }

    fun notifyViewAdaptor() {
        viewAdaptor.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        notifyViewAdaptor()
    }


}
