package com.example.upeers.msglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.R

class MessageListActivity : AppCompatActivity() {
    private lateinit var mMessageRecycler : RecyclerView
    private lateinit var mMessageListAdapter: MessageListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_list)


        val messageList = listOf<Message>(
            Message("As usual", User("Tongyu", R.drawable.alex), System.currentTimeMillis()),
            Message("Not that much", User("Alex", R.drawable.alex), System.currentTimeMillis()),
            Message("As usual", User("Tongyu", R.drawable.alex), System.currentTimeMillis()),
            Message("Not that much", User("Alex", R.drawable.alex), System.currentTimeMillis()),
            Message("As usual", User("Tongyu", R.drawable.alex), System.currentTimeMillis()),
            Message("Not that much", User("Alex", R.drawable.alex), System.currentTimeMillis()),
            Message("As usual", User("Tongyu", R.drawable.alex), System.currentTimeMillis()),
            Message("Not that much", User("Alex", R.drawable.alex), System.currentTimeMillis()),
            Message("As usual", User("Tongyu", R.drawable.alex), System.currentTimeMillis()),
            Message("As usual", User("Tongyu", R.drawable.alex), System.currentTimeMillis()),
            Message("As usual", User("Tongyu", R.drawable.alex), System.currentTimeMillis()),
            Message("As usual", User("Tongyu", R.drawable.alex), System.currentTimeMillis()),
            Message("Not that much", User("Alex", R.drawable.alex), System.currentTimeMillis()),
            Message("Not that much", User("Alex", R.drawable.alex), System.currentTimeMillis())
        )

        mMessageRecycler = findViewById<RecyclerView>(R.id.recyclerview_msg_list)
        mMessageRecycler.setHasFixedSize(true);

        mMessageListAdapter = MessageListAdapter(this, messageList)
        mMessageRecycler.layoutManager = LinearLayoutManager(this)
        mMessageRecycler.adapter = mMessageListAdapter
    }
}
