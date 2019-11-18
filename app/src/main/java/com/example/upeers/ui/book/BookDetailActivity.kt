package com.example.upeers.ui.book

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.upeers.R
import androidx.viewpager.widget.ViewPager
import com.example.upeers.BookMsgList
import com.example.upeers.msglist.MessageListActivity
import com.viewpagerindicator.CirclePageIndicator
import java.util.ArrayList


class BookDetailActivity  : AppCompatActivity() {
    private var imageModelArrayList: ArrayList<ImageModel>? = null
    private val myImageList = intArrayOf(R.drawable.textbook_preview, R.drawable.textbook_preview_2, R.drawable.textbook_preview_3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        imageModelArrayList = ArrayList()
        imageModelArrayList = populateList()
        init()

    }

    private fun populateList(): ArrayList<ImageModel> {

        val list = ArrayList<ImageModel>()

        for (i in 0..2) {
            val imageModel = ImageModel()
            imageModel.setImageDrawables(myImageList[i])
            list.add(imageModel)
        }
        return list
    }

    private fun init() {

        mPager = findViewById(R.id.img_pager) as? ViewPager
        mPager!!.adapter = SlidingImageAdapter(this@BookDetailActivity, this.imageModelArrayList!!)

        val indicator = findViewById(R.id.img_indicator) as CirclePageIndicator
        indicator.setViewPager(mPager)

        val density = resources.displayMetrics.density
        //Set circle indicator radius
        indicator.setRadius(5 * density)
        NUM_PAGES = imageModelArrayList!!.size

        // Pager listener over indicator
        indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                currentPage = position
            }

            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {}

            override fun onPageScrollStateChanged(pos: Int) {}
        })
    }

    companion object {
        private var mPager: ViewPager? = null
        private var currentPage = 0
        private var NUM_PAGES = 0
    }

    fun onClickContact(view: View) {
        val intent = Intent(this, BookMsgList::class.java).apply {
            //            should use putExtra here I guess
        }
        startActivity(intent)
    }
}
