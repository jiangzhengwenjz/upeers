package com.example.upeers.message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView
import com.example.upeers.R
import kotlinx.android.synthetic.main.layout_message_contact_card.view.*
import org.w3c.dom.Text

class MessageUserInfoAdapter(val mCtx: Context, private val myDataSet: List<MessageUserInfo>) :
    RecyclerView.Adapter<MessageUserInfoAdapter .MessageUserInfoViewHolder>(){

    class MessageUserInfoViewHolder(val userInfoView: View)  : RecyclerView.ViewHolder(userInfoView) {
        val label: TextView = userInfoView.findViewById(R.id.label)
        val username: TextView = userInfoView.findViewById(R.id.username)
        val active: TextView = userInfoView.findViewById(R.id.active)
        val lastMessage: TextView = userInfoView.findViewById(R.id.lastMessage)
        val avatar: ImageView = userInfoView.findViewById(R.id.avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageUserInfoAdapter. MessageUserInfoViewHolder {

        // Create New View
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_message_contact_card, parent, false) as View

        return  MessageUserInfoViewHolder(cardView)
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