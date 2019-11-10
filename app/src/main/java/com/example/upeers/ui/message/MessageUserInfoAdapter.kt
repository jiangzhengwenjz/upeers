package com.example.upeers.ui.message

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.R
import com.example.upeers.msglist.MessageListActivity
import kotlinx.android.synthetic.main.layout_message_contact_card.view.*

open class MessageUserInfoAdapter(private val myDataSet: List<MessageUserInfo>, private val context: Context?) :
    RecyclerView.Adapter<MessageUserInfoAdapter.MessageUserInfoViewHolder>(){

    open class MessageUserInfoViewHolder(val userInfoView: View)  : RecyclerView.ViewHolder(userInfoView) {
        val label: TextView = userInfoView.findViewById(R.id.label)
        val username: TextView = userInfoView.findViewById(R.id.username)
        val active: TextView = userInfoView.findViewById(R.id.active)
        val lastMessage: TextView = userInfoView.findViewById(R.id.lastMessage)
        val avatar: ImageView = userInfoView.findViewById(R.id.avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageUserInfoViewHolder {

        // Create New View
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_message_contact_card, parent, false) as View

//        cardView.setOnClickListener {
//        }

        return MessageUserInfoViewHolder(
            cardView
        )
    }

    override fun onBindViewHolder(holder: MessageUserInfoViewHolder, position: Int) {
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
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }

}
