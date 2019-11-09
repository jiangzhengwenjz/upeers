package com.example.upeers.msgsearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.R
import com.example.upeers.ui.message.MessageUserInfoAdapter

class MsgSingleLineAdaptor(private val searchResults: List<String>) : RecyclerView.Adapter<MsgSingleLineAdaptor.MsgSingleLineViewHolder>() {

    open class MsgSingleLineViewHolder(val userInfoView: View)  : RecyclerView.ViewHolder(userInfoView) {
        val entry: TextView = userInfoView.findViewById(R.id.entry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgSingleLineViewHolder {

        // Create New View
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_message_search_entry, parent, false) as View

        return MsgSingleLineViewHolder(
            cardView
        )
    }

    override fun onBindViewHolder(holder: MsgSingleLineViewHolder, position: Int) {
        holder.entry.text = searchResults[position]

    }

    override fun getItemCount(): Int {
        return searchResults.size
    }
}
