package com.example.upeers.coursepage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.example.upeers.R

/**
 * A simple [Fragment] subclass.
 */
class BookFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_book, container, false)
        val bookStdImg: ImageView = root.findViewById(R.id.book_std_img)
        bookStdImg.setImageResource(R.drawable.design_norman)
        return root
    }


}
