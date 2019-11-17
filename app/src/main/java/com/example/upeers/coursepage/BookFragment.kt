package com.example.upeers.coursepage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.upeers.R

/**
 * A simple [Fragment] subclass.
 */
class BookFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdaptor: BookListAdaptor
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var books: List<BookInfo>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        books = listOf<BookInfo>(
            BookInfo(
                27,
                "Keller Hall",
                "Almost brand new book without any mark",
                R.drawable.book_example4,
                R.drawable.book_example2,
                5),
            BookInfo(28,
                "Stadium Villiage",
                "Perfect condition with a little note on pages",
                R.drawable.book_example3,
                R.drawable.book_example1,
                7),
            BookInfo(35,
                "Northrop",
                "My book looks like a new one",
                R.drawable.book_example2,
                R.drawable.book_example4,
                0)
        )
        val root = inflater.inflate(R.layout.fragment_book, container, false)
        val bookStdImg: ImageView = root.findViewById(R.id.book_std_img)
        bookStdImg.setImageResource(R.drawable.design_norman)

        viewManager = LinearLayoutManager(activity)
        viewAdaptor = BookListAdaptor(books, this.context)

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
                    sortPrice()
                } else if (idInt == 1) {
                    sortViewCount()
                } else if (idInt == 2) {
                    sortDistance()
                }
                notifyViewAdaptor()
            }
        }
        return root
    }

    fun sortPrice() {
        viewAdaptor.myDataSet = listOf<BookInfo>(
            BookInfo(
                27,
                "Keller Hall",
                "Almost brand new book without any mark",
                R.drawable.book_example4,
                R.drawable.book_example2,
                5),
            BookInfo(28,
                "Northrop",
                "Perfect condition with a little note on pages",
                R.drawable.book_example3,
                R.drawable.book_example1,
                7),
            BookInfo(35,
                "Stadium Villiage",
                "My book looks like a new one",
                R.drawable.book_example2,
                R.drawable.book_example4,
                0)
        )
    }

    fun sortViewCount() {
        viewAdaptor.myDataSet = listOf<BookInfo>(
            BookInfo(28,
                "Northrop",
                "Perfect condition with a little note on pages",
                R.drawable.book_example3,
                R.drawable.book_example1,
                7),
            BookInfo(
                27,
                "Keller Hall",
                "Almost brand new book without any mark",
                R.drawable.book_example4,
                R.drawable.book_example2,
                5),
            BookInfo(35,
                "Stadium Villiage",
                "My book looks like a new one",
                R.drawable.book_example2,
                R.drawable.book_example4,
                0)
        )
    }

    fun sortDistance() {
        viewAdaptor.myDataSet = listOf<BookInfo>(
            BookInfo(
                27,
                "Keller Hall",
                "Almost brand new book without any mark",
                R.drawable.book_example4,
                R.drawable.book_example2,
                5),
            BookInfo(35,
                "Stadium Villiage",
                "My book looks like a new one",
                R.drawable.book_example2,
                R.drawable.book_example4,
                0),
            BookInfo(28,
                "Northrop",
                "Perfect condition with a little note on pages",
                R.drawable.book_example3,
                R.drawable.book_example1,
                7)
        )
    }

    fun notifyViewAdaptor() {
        viewAdaptor.notifyDataSetChanged()
    }
}
