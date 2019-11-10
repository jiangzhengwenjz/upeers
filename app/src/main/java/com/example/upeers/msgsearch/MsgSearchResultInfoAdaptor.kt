package com.example.upeers.msgsearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.R
import com.example.upeers.ui.message.MessageUserInfo
import com.example.upeers.ui.message.MessageUserInfoAdapter
import kotlinx.android.synthetic.main.layout_message_search_result.view.*

class MsgSearchResultInfoAdaptor(private val myDataSet: List<MsgSearchResultInfo>) : RecyclerView.Adapter<MsgSearchResultInfoAdaptor.MsgSearchResultInfoViewHolder>() {
    class MsgSearchResultInfoViewHolder(userInfoView: View) : RecyclerView.ViewHolder(userInfoView) {
        val label: TextView = userInfoView.findViewById(R.id.label)
        val username: TextView = userInfoView.findViewById(R.id.username)
        val active: TextView = userInfoView.findViewById(R.id.active)
        val lastMessage: TextView = userInfoView.findViewById(R.id.lastMessage)
        val avatar: ImageView = userInfoView.findViewById(R.id.avatar)
        // to display the search result of the messages under one users
        val msgSearchContent : RecyclerView = userInfoView.findViewById(R.id.msg_search_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgSearchResultInfoViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_message_search_result, parent, false) as View

        return MsgSearchResultInfoViewHolder(
            cardView
        )
    }

    override fun onBindViewHolder(holder: MsgSearchResultInfoViewHolder, position: Int) {
        holder.label.text = myDataSet[position].label
        holder.username.text = myDataSet[position].name
        holder.active.text = if (myDataSet[position].active) {
            "active"
        } else {
            "away"
        }
        holder.lastMessage.text = myDataSet[position].lastMsg
        // need to set image here
        holder.avatar.setImageResource(myDataSet[position].avatar)

        holder.msgSearchContent.setHasFixedSize(true)

        holder.msgSearchContent.layoutManager = LinearLayoutManager(holder.msgSearchContent.context)

        val entries = myDataSet[position].searchResultContent

        holder.msgSearchContent.adapter = MsgSingleLineAdaptor(entries)

    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }

}

