package com.example.upeers.coursepage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.upeers.R
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.upeers.tutordetail.TutorDetailActivity
import com.example.upeers.ui.home.CourseInfo
import com.example.upeers.ui.home.HomeFragment


class CoursePageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_page)

        val viewPager = findViewById(R.id.courseViewpager) as ViewPager
        val tabLayout = findViewById<View>(R.id.courseTabLayout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
        setupViewPager(viewPager)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = Adapter(supportFragmentManager)
        adapter.addFragment(CourseInfoFragment(), "Info")
        adapter.addFragment(CourseInfoFragment(), "Books")
        adapter.addFragment(TutorListFragment(), "Tutors")
        adapter.addFragment(CourseInfoFragment(), "Forum")
        viewPager.adapter = adapter
    }

    internal class Adapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        private val mFragments = ArrayList<Fragment>()
        private val mFragmentTitles = ArrayList<String>()

        fun addFragment(fragment: Fragment, title: String) {
            mFragments.add(fragment)
            mFragmentTitles.add(title)
        }

        override fun getItem(position: Int): Fragment {
            return mFragments.get(position)
        }

        override fun getCount(): Int {
            return mFragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitles.get(position)
        }
    }

    fun onClickTutor(view: View) {
        val intent = Intent(this, TutorDetailActivity::class.java).apply {
            // should use putExtra here I guess
        }
        startActivity(intent)
    }

}
