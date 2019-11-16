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
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import com.example.upeers.ui.message.MessageFragment
import java.io.File
import java.util.jar.Manifest


class MessageListActivity : AppCompatActivity() {
    // for call back
    private val RESULT_LOAD_IMAGE = 1
    private val PERMISSION_REQUEST_READ_EXT_STORAGE = 8
    private val PERMISSION_REQUEST_WRITE_EXT_STORAGE = 9

    private lateinit var mMessageRecycler : RecyclerView
    private lateinit var mMessageListAdapter: MessageListAdapter
    private lateinit var chatbox : LinearLayout
    private lateinit var chattools : LinearLayout
    private lateinit var messageList: ArrayList<Message>
    private val userRemote : User = User("Tongyu", R.drawable.alex)
    private val userMe : User = User("Alex", R.drawable.alex)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_list)

        val toolbar:Toolbar = findViewById<Toolbar>(R.id.msg_list_toolbar)
        setSupportActionBar(toolbar)

        // hide chat tool
        chatbox = findViewById<LinearLayout>(R.id.layout_chatbox)
        chattools = findViewById<LinearLayout>(R.id.layout_chattools)
        chattools.visibility = View.INVISIBLE



        messageList = arrayListOf(
            Message("As usual", userRemote, System.currentTimeMillis()),
            Message("Not that much", userMe, System.currentTimeMillis()),
            Message("As usual", userRemote, System.currentTimeMillis()),
            Message("Not that much", userMe, System.currentTimeMillis()),
            Message("As usual", userRemote, System.currentTimeMillis()),
            Message("Not that much", userMe, System.currentTimeMillis()),
            Message("As usual", userRemote, System.currentTimeMillis()),
            Message("Not that much", userMe, System.currentTimeMillis()),
            Message("As usual", userRemote, System.currentTimeMillis()),
            Message("As usual", userRemote, System.currentTimeMillis()),
            Message("As usual", userRemote, System.currentTimeMillis()),
            Message("As usual", userRemote, System.currentTimeMillis()),
            Message("Not that much", userMe, System.currentTimeMillis()),
            Message("Not that much", userMe, System.currentTimeMillis())
        )

        mMessageRecycler = findViewById<RecyclerView>(R.id.recyclerview_msg_list)
        mMessageRecycler.setHasFixedSize(true);

        mMessageListAdapter = MessageListAdapter(this, messageList)
        mMessageRecycler.layoutManager = LinearLayoutManager(this)
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
            mMessageListAdapter.notifyDataSetChanged()
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
}
