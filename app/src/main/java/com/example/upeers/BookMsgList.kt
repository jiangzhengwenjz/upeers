package com.example.upeers

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
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

        // set image for the book
        val bookPreview : ImageView = findViewById(R.id.book_std_img)
        bookPreview.setImageResource(R.drawable.design_norman)

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

    fun onDealClicked(view: View) {
        val button = view as Button
        val builder = AlertDialog.Builder(this)
        button.setBackgroundColor(Color.parseColor("#999999"))
        button.setTextColor(Color.parseColor("#444444"))
        button.text = "Deal Made"
        builder.setTitle("You will buy the book")
        builder.setMessage("Please click CONFIRM to set up this deal")
        builder.setPositiveButton("CONFIRM"){dialog, which ->
            // Do something when user press the positive button
            Toast.makeText(applicationContext,"OK, the deal is made",Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("CANCEL"){dialog,which ->
        }

    }
}
