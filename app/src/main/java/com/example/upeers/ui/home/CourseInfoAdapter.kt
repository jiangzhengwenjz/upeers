package com.example.upeers.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.R

//class CourseInfo(
//    val courseSubject: String,
//    val courseNumber: Int,
//    val teacherName: String,
//    val year: Int,
//    val isFall: Boolean
//) {}
class CourseInfoAdapter (private val myDataSet: List<CourseInfo>):
        RecyclerView.Adapter<CourseInfoAdapter.CourseInfoViewHolder>() {

    class CourseInfoViewHolder(val CourseInfoView: View): RecyclerView.ViewHolder(CourseInfoView) {
        val courseSubject: TextView = CourseInfoView.findViewById(R.id.course_subject)
        val courseNumber: TextView = CourseInfoView.findViewById(R.id.course_number)
        val teacherName: TextView = CourseInfoView.findViewById(R.id.teacher_name)
        val year: TextView = CourseInfoView.findViewById(R.id.year)
        val semester: TextView = CourseInfoView.findViewById(R.id.semester)
        val courseName: TextView = CourseInfoView.findViewById(R.id.course_name)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseInfoViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_course_info_card, parent, false) as View

        return CourseInfoViewHolder(
            cardView
        )
    }

    override fun onBindViewHolder(holder: CourseInfoViewHolder, position: Int) {
        holder.courseSubject.text = myDataSet[position].courseSubject
        holder.courseNumber.text = myDataSet[position].courseNumber.toString()
        holder.year.text = myDataSet[position].year.toString()
        holder.semester.text = if (myDataSet[position].isFall) "FALL" else "SPRING"
        holder.teacherName.text = myDataSet[position].teacherName
        holder.courseName.text = myDataSet[position].courseName

        // need to set image here
//        holder.avatar.setImageResource(myDataSet[position].avatar)    }
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }
}
