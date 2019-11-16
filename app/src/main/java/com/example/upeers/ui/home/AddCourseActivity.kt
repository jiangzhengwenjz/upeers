package com.example.upeers.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.upeers.MainNaviActivity
import com.example.upeers.R

class AddCourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)
    }


    fun onClickAddCourse_closeActivity(view:View) {
//        a pop up alert dialog.

            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(this)

            // set message of alert dialog
            dialogBuilder.setMessage("Successfully added the course!")
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Got it", DialogInterface.OnClickListener {
                        dialog, id -> closeActivity(view)
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("Course added")
            // show alert dialog
            alert.show()
    }

    fun closeActivity(view: View) {
        finish()
        val intent = Intent (this, MainNaviActivity::class.java).apply {}
        startActivity(intent)

    }
}
