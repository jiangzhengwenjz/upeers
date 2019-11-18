package com.example.upeers.msglist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.R
import java.util.zip.Inflater
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import com.example.upeers.tutordetail.TutorDetailActivity
import com.example.upeers.drawingpad.FakeDrawingPadActivity
import com.example.upeers.msgsearch.MsgSearchActivity
import com.example.upeers.ui.message.MessageFragment
import java.io.File
import java.util.jar.Manifest


open class MessageListActivity : AppCompatActivity() {
    // for call back
    protected val RESULT_LOAD_IMAGE = 1
    protected val PERMISSION_REQUEST_READ_EXT_STORAGE = 8
    protected val PERMISSION_REQUEST_WRITE_EXT_STORAGE = 9

    protected lateinit var mMessageRecycler : RecyclerView
    protected lateinit var mMessageListAdapter: MessageListAdapter
    protected lateinit var chatbox : LinearLayout
    protected lateinit var chattools : LinearLayout
    // private lateinit var messageList: ArrayList<Message>
    protected val userRemote : User = User("Alex", R.drawable.alex)
    protected val userMe : User = User("Tongyu", R.drawable.alex)

    protected var messageList = arrayListOf(
        Message("Hey, how are u", userMe, System.currentTimeMillis()),
        Message("Great! What's up", userRemote, System.currentTimeMillis()),
        Message("So, I want to add a recyclerview feature in my APP.", userMe, System.currentTimeMillis()),
        Message("Have you installed Android Studio", userRemote, System.currentTimeMillis()),
        Message("Yes", userMe, System.currentTimeMillis()),
        Message("Ok, great", userRemote, System.currentTimeMillis()),
        Message("Can you go to the app src? Look at the java directory", userRemote, System.currentTimeMillis()),
        Message("OK", userMe, System.currentTimeMillis()),
        Message("Now, can you see the RecyclerDemo.java?", userRemote, System.currentTimeMillis()),
        Message("Yes", userMe, System.currentTimeMillis()),
        Message("I can see that", userMe, System.currentTimeMillis()),
        Message("Now what should I do?", userMe, System.currentTimeMillis()),
        Message("Just follow the demo you will figure it out. Check the tutorial 3", userRemote, System.currentTimeMillis()),
        Message("Good luck.", userRemote, System.currentTimeMillis())//,
        // Message("Alright, thank you", userMe, System.currentTimeMillis())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_list)

        val toolbar:Toolbar = findViewById<Toolbar>(R.id.msg_list_toolbar)
        setSupportActionBar(toolbar)

        // hide chat tool
        chatbox = findViewById<LinearLayout>(R.id.layout_chatbox)
        chattools = findViewById<LinearLayout>(R.id.layout_chattools)
        chattools.visibility = View.INVISIBLE

        mMessageRecycler = findViewById<RecyclerView>(R.id.recyclerview_msg_list)
        mMessageRecycler.setHasFixedSize(true);

        mMessageListAdapter = MessageListAdapter(this, messageList)
        // set sth for layout manager
        val llm = LinearLayoutManager(this)
        llm.stackFromEnd = true
        mMessageRecycler.layoutManager = llm
        mMessageRecycler.adapter = mMessageListAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mgs_list_toolbar, menu);
        return true;
    }

    // user clicked + button
    fun onAddClicked(view: View) {
        chatbox.visibility = View.INVISIBLE
        chattools.visibility = View.VISIBLE
    }

    // user clicked keyboard button to go back to chat box
    fun onBackToChatBoxClicked(view: View) {
        chattools.visibility = View.INVISIBLE
        chatbox.visibility = View.VISIBLE
    }

    // user clicked gallery button
    fun onGalleryClicked(view: View) {
        // we need permission to access gallery
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            checkPermissions(arrayOf(
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            ), PERMISSION_REQUEST_READ_EXT_STORAGE)
        } else {
            openGallery()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            val selectedImage:Uri = (data.data as Uri)
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)

            val cursor = contentResolver.query(
                selectedImage!!,
                filePathColumn, null, null, null
            )
            cursor!!.moveToFirst()

            val columnIndex = cursor.getColumnIndex(filePathColumn[0])
            val picturePath = cursor.getString(columnIndex)
            cursor.close()

            messageList.add(Message(picturePath, userMe, System.currentTimeMillis(), true, selectedImage))
            // mMessageListAdapter.notifyDataSetChanged()
            mMessageListAdapter.notifyItemInserted(mMessageListAdapter.getItemCount()-1);
            mMessageRecycler.scrollToPosition(mMessageListAdapter.getItemCount()-1);
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, RESULT_LOAD_IMAGE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_REQUEST_READ_EXT_STORAGE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    openGallery()
                }
            }

        }
    }

    fun hasPermissions(context: Context, vararg permissions: String): Boolean = permissions.all {
        ActivityCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
    }

    private fun checkPermissions(permissions: Array<String>, requestCode: Int) {
        if (!hasPermissions(this, *permissions)) {
            ActivityCompat
                .requestPermissions(
                    this,
                    permissions,
                    requestCode
                )
        } else {
            openGallery()
        }
    }

    fun onGiveKudosClicked(menuItem: MenuItem) {
        // give a form when user clicked give kudos
        val fm : FragmentManager = supportFragmentManager
        val giveKudos : RatingBarDialog = RatingBarDialog()
        giveKudos.show(fm, "nty")
    }

    fun onAvatarClicked(view: View) {
        val intent = Intent(this, TutorDetailActivity::class.java).apply {
            // should use putExtra here I guess
        }
        startActivity(intent)
    }

    fun onClickDrawingPad(view: View) {
        val intent = Intent(this, FakeDrawingPadActivity::class.java).apply {
        }
        startActivity(intent)
    }

    fun onClickSend(view: View) {
        val editText: EditText = findViewById(R.id.edittext_chatbox)
        val text = editText.text.toString()
        editText.text.clear()
        editText.clearFocus()
        messageList.add(Message(text, userMe, System.currentTimeMillis()))
        // mMessageListAdapter.notifyDataSetChanged()
        mMessageListAdapter.notifyItemInserted(mMessageListAdapter.getItemCount()-1);
        mMessageRecycler.scrollToPosition(mMessageListAdapter.getItemCount()-1);
    }
}
