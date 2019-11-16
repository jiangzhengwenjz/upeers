package com.example.upeers.msglist

import android.app.Dialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

import com.example.upeers.R

class RatingBarDialog :DialogFragment () {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater
            // Here we set the title I guess?
            builder.setView(inflater.inflate(R.layout.dialog_give_kudos, null)).setMessage(R.string.give_kudos)
                .setPositiveButton(R.string.confirm,
                    DialogInterface.OnClickListener { dialog, id ->
                        // FIRE ZE MISSILES!
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}

