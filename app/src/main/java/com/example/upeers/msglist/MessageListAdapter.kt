package com.example.upeers.msglist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.R
import com.sendbird.androidchattutorial.Utils
import java.time.format.DateTimeFormatter
import java.util.*


class MessageListAdapter(private val mContext:Context,
                         private val mMessageList: List<Message>) : RecyclerView.Adapter<MessageListAdapter.SentMessageHolder>(){
    private val VIEW_TYPE_MESSAGE_SENT = 1
    private val VIEW_TYPE_MESSAGE_RECEIVED = 2
    private val ME = "Alex"

    open inner class SentMessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageText: TextView = itemView.findViewById(R.id.text_message_body)
        val timeText: TextView = itemView.findViewById(R.id.text_message_time)

        open fun bind(message: Message) {
            messageText.text = message.message

            // Format the stored timestamp into a readable String using method.
            timeText.text = Utils.formatTime(message.createdAt)
        }
    }

    inner class ReceivedMessageHolder(itemView: View) : MessageListAdapter.SentMessageHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.text_message_name)
        val profileImage: ImageView = itemView.findViewById(R.id.image_message_profile)

        override fun bind(message: Message) {
            super.bind(message)
            nameText.text = message.sender.nickname

            // Insert the profile image from the URL into the ImageView.
//            Utils.displayRoundImageFromUrl(mContext, message.sender.porfileUrl, profileImage);
            profileImage.setImageResource(message.sender.profileAvatar)
        }
    }


    override fun getItemCount(): Int {
        return mMessageList.size
    }

    override fun getItemViewType(position: Int): Int {
        val message = mMessageList.get(position)

        if (message.sender.nickname.equals(ME)) {
            // current user sent out the message
            return VIEW_TYPE_MESSAGE_SENT
        } else {
            // other user sent this message
            return VIEW_TYPE_MESSAGE_RECEIVED
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SentMessageHolder {
        val view: View
        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_sent, parent, false)
            return SentMessageHolder(view)
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_received, parent, false)
            return ReceivedMessageHolder(view)
        }

        return null!!
    }

    override fun onBindViewHolder(holder: SentMessageHolder, position: Int) {
        val message : Message = mMessageList.get(position)

        when (holder.itemViewType) {
            VIEW_TYPE_MESSAGE_SENT -> holder.bind(message)
            VIEW_TYPE_MESSAGE_RECEIVED -> (holder as ReceivedMessageHolder).bind(message)
        }
    }
}
