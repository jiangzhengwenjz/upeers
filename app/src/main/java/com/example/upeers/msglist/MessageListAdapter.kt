package com.example.upeers.msglist

import android.content.Context
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.R
import com.sendbird.androidchattutorial.Utils


class MessageListAdapter(private val mContext:Context,
                         private val mMessageList: List<Message>) : RecyclerView.Adapter<MessageListAdapter.BasicMessageHolder>(){
    private val VIEW_TYPE_MESSAGE_SENT = 1
    private val VIEW_TYPE_MESSAGE_RECEIVED = 2
    private val VIEW_TYPE_MESSAGE_IMG_SENT = 3
    private val ME = "Tongyu"

    open inner class BasicMessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val timeText: TextView = itemView.findViewById(R.id.text_message_time)

        open fun bind(message: Message) {
            // Format the stored timestamp into a readable String using method.
            timeText.text = Utils.formatTime(message.createdAt)
        }
    }

    open inner class SentMessageHolder(itemView: View) : BasicMessageHolder(itemView) {
        val messageText: TextView = itemView.findViewById(R.id.text_message_body)

        override fun bind(message: Message) {
            messageText.text = message.message

        }
    }

    inner class SentImageHolder(itemView: View) : BasicMessageHolder(itemView) {
        val messageImg: ImageView = itemView.findViewById(R.id.text_messageimg_body)

        override fun bind(message: Message) {
            messageImg.setImageURI(message.uri)
        }
    }

    inner class ReceivedMessageHolder(itemView: View) : MessageListAdapter.SentMessageHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.text_message_name)
        val profileImage: ImageView = itemView.findViewById(R.id.image_message_profile)

        override fun bind(message: Message) {
            super.bind(message)
            nameText.text = message.sender.nickname

            // Insert the profile image from the URL into the ImageView.
            profileImage.setImageResource(message.sender.profileAvatar)
        }
    }


    override fun getItemCount(): Int {
        return mMessageList.size
    }

    override fun getItemViewType(position: Int): Int {
        val message = mMessageList.get(position)

        if (message.isImage) {
            // sent out img
            return VIEW_TYPE_MESSAGE_IMG_SENT
        }
        else if (message.sender.nickname.equals(ME)) {
            // current user sent out the message
            return VIEW_TYPE_MESSAGE_SENT
        } else {
            // other user sent this message
            return VIEW_TYPE_MESSAGE_RECEIVED
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicMessageHolder {
        val view: View
        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_sent, parent, false)
            return SentMessageHolder(view)
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_received, parent, false)
            return ReceivedMessageHolder(view)
        } else if (viewType == VIEW_TYPE_MESSAGE_IMG_SENT) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_img_sent, parent,false)
            return SentImageHolder(view)
        }

        return null!!
    }

    override fun onBindViewHolder(holder: BasicMessageHolder, position: Int) {
        val message : Message = mMessageList.get(position)

        when (holder.itemViewType) {
            VIEW_TYPE_MESSAGE_SENT -> (holder as SentMessageHolder).bind(message)
            VIEW_TYPE_MESSAGE_RECEIVED -> (holder as ReceivedMessageHolder).bind(message)
            VIEW_TYPE_MESSAGE_IMG_SENT -> (holder as SentImageHolder).bind(message)
        }
    }

}
