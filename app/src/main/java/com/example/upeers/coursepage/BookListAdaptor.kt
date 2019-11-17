package com.example.upeers.coursepage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.R
import kotlinx.android.synthetic.main.layout_book_info_card.view.*


class BookListAdaptor(var myDataSet: List<BookInfo>,
                      private val context: Context?) : RecyclerView.Adapter<BookListAdaptor.BookInfoViewHolder>() {
    private val DOLLAR: String = "$"
    private val PEOPLE_VIEWED: String = " people have taken a look"
    class BookInfoViewHolder(val bookInfoView: View) : RecyclerView.ViewHolder(bookInfoView) {
        val bookNumId: TextView = bookInfoView.findViewById(R.id.book_num_id)
        val price: TextView = bookInfoView.findViewById(R.id.book_price)
        val location: TextView = bookInfoView.findViewById(R.id.book_place)
        val description: TextView = bookInfoView.findViewById(R.id.book_description)
        val image_1 : ImageView = bookInfoView.findViewById(R.id.book_img_1)
        val image_2 : ImageView = bookInfoView.findViewById(R.id.book_img_2)
        val viewCount: TextView = bookInfoView.findViewById(R.id.book_view_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookInfoViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_book_info_card, parent, false) as View
        return BookInfoViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: BookInfoViewHolder, position: Int) {
        val data = myDataSet[position]
        holder.bookNumId.text = (position + 1).toString()
        holder.price.text = DOLLAR + data.price.toString()
        holder.location.text = data.location
        holder.description.text = data.description
        holder.image_1.setImageResource(data.image_1)
        holder.image_2.setImageResource(data.image_2)
        holder.viewCount.text = data.viewCount.toString() + PEOPLE_VIEWED
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }
}