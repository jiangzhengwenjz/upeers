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

class MsgSearchResultInfoAdaptor(private val myDataSet: List<MsgSearchResultInfo>) : MessageUserInfoAdapter(myDataSet) {
    class MsgSearchResultInfoViewHolder(userInfoView: View) : MessageUserInfoViewHolder(userInfoView) {
        val msgSearchContent : RecyclerView = userInfoView.findViewById(R.id.msg_search_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageUserInfoViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_message_search_result, parent, false) as View

        return MessageUserInfoViewHolder(
            cardView
        )
    }

    fun onBindViewHolder(holder: MsgSearchResultInfoViewHolder, position: Int) {
        // holder.label.text = myDataSet[position].label
        // holder.username.text = myDataSet[position].name
        // holder.active.text = if (myDataSet[position].active) {
        //     "active"
        // } else {
        //     "away"
        // }
        // holder.lastMessage.text = myDataSet[position].lastMsg
        // // need to set image here
        // holder.avatar.setImageResource(myDataSet[position].avatar)
        super.onBindViewHolder(holder, position)
        holder.msgSearchContent.apply {
            setHasFixedSize(true)

            layoutManager = LinearLayoutManager(holder.userInfoView.context)

            val entries = myDataSet[position].searchResultContent

            adapter = MsgSingleLineAdaptor(entries)
        }
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }
}
