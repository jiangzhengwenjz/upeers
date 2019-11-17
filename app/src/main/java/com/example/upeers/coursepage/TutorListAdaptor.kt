package com.example.upeers.coursepage

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.R
import kotlinx.android.synthetic.main.layout_tutor_card.view.*

class TutorListAdaptor(private val myDataSet: List<TutorInfo>,
                       private val context: Context?) : RecyclerView.Adapter<TutorListAdaptor.TutorInfoViewHolder>(){

    class TutorInfoViewHolder(val tutorInfoView: View) : RecyclerView.ViewHolder(tutorInfoView) {
        val tutorName: TextView = tutorInfoView.findViewById(R.id.tutor_name)
        val rating: TextView = tutorInfoView.findViewById(R.id.tutor_rate)
        val avatar: ImageView = tutorInfoView.findViewById(R.id.tutor_avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorInfoViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_tutor_card, parent, false) as View
        return TutorInfoViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: TutorInfoViewHolder, position: Int) {
        val data = myDataSet[position]
        holder.tutorName.text = data.tutorName
        holder.rating.text = data.rating
        holder.avatar.setImageResource(data.avatar)
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }
}