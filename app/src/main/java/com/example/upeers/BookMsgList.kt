package com.example.upeers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.msglist.Message
import com.example.upeers.msglist.MessageListActivity
import com.example.upeers.msglist.MessageListAdapter
import com.example.upeers.msglist.User


class BookMsgList : MessageListActivity() {
    // for call back
//    private val RESULT_LOAD_IMAGE = 1
//    private val PERMISSION_REQUEST_READ_EXT_STORAGE = 8
//    private val PERMISSION_REQUEST_WRITE_EXT_STORAGE = 9
//
//    private lateinit var mMessageRecycler : RecyclerView
//    private lateinit var mMessageListAdapter: MessageListAdapter
//    private lateinit var chatbox : LinearLayout
//    private lateinit var chattools : LinearLayout
//    private lateinit var messageList: ArrayList<Message>
//    private val userRemote : User = User("Tongyu", R.drawable.alex)
//    private val userMe : User = User("Alex", R.drawable.alex)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_msg_list)

        val toolbar: Toolbar = findViewById<Toolbar>(R.id.msg_list_toolbar)
        setSupportActionBar(toolbar)

        // hide chat tool
        chatbox = findViewById<LinearLayout>(R.id.layout_chatbox)
        chattools = findViewById<LinearLayout>(R.id.layout_chattools)
        chattools.visibility = View.INVISIBLE

        messageList = arrayListOf(
            Message("Hi! Your book looks very good. I would like to take it!", userMe, System.currentTimeMillis()),
            Message("OK! Shall we meet at Keller Hall at 4:30 pm this Tuesday?", userRemote, System.currentTimeMillis()),
            Message("Sure, see u~", userRemote, System.currentTimeMillis()),
            Message("See you.", userMe, System.currentTimeMillis())
        )

        mMessageRecycler = findViewById<RecyclerView>(R.id.recyclerview_msg_list)
        mMessageRecycler.setHasFixedSize(true);

        mMessageListAdapter = MessageListAdapter(this, messageList)
        // set sth for layout manager
        val llm = LinearLayoutManager(this)
        llm.stackFromEnd = true
        mMessageRecycler.layoutManager = llm
        mMessageRecycler.adapter = mMessageListAdapter
    }
}