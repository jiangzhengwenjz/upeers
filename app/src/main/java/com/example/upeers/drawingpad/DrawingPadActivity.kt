package com.example.upeers.drawingpad

import android.content.DialogInterface
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import com.example.upeers.R
import com.example.upeers.drawingpad.utilities.Drawing
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

@Suppress("DEPRECATION")
class DrawingPadActivity : AppCompatActivity() {

    private var drawingPad: Drawing? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawing_pad)

        drawingPad = findViewById(R.id.canvas)
        drawingPad!!.isDrawingCacheEnabled = true
    }

    fun clearCanvas(view: View) {

        val dialogClickListener = DialogInterface.OnClickListener { dialog, which ->
            if (which == DialogInterface.BUTTON_POSITIVE) {
                drawingPad!!.clearAll()
            } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                dialog!!.dismiss()
            }
        }

        val builder = AlertDialog.Builder(this@DrawingPadActivity)
        builder.setTitle("Clear")
            .setMessage("Are you sure you want to clear?")
            .setPositiveButton("Yes", dialogClickListener)
            .setNegativeButton("No", dialogClickListener)
        val n = builder.create()
        n.show()
    }

    fun onColorChanged(selectedColor: Int) {
        drawingPad!!.setBrushColor(selectedColor)
    }

    fun onSizeSelected(selectedSize: Float) {
        drawingPad!!.setBrushSize(selectedSize)
    }


    @Throws(IOException::class)
    fun saveCanvas(view: View) {
        var path = Environment.getExternalStorageDirectory().toString()
        path = "$path/Drawings"
        val dir = File(path)
        drawingPad!!.isDrawingCacheEnabled = true

        val name = "Drawing_" + System.currentTimeMillis() + ".png"
        val savedImage = MediaStore.Images.Media.insertImage(contentResolver, drawingPad!!.drawingCache, name, "A drawing")

        try {

            if (!dir.isDirectory || !dir.exists()) {
                dir.mkdirs()
            }

            drawingPad!!.isDrawingCacheEnabled = true
            val file = File(dir, name)
            val fileOutputStream = FileOutputStream(file)
            val bitmap = drawingPad!!.drawingCache
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)

        } catch (e: FileNotFoundException) {

            val builder = AlertDialog.Builder(this@DrawingPadActivity)
            builder.setTitle("Error")
                .setMessage("Ooops! Could not save.")
                .setNegativeButton("CANCEL") { dialogInterface, _ -> dialogInterface.dismiss() }
            val n = builder.create()
            n.show()
        }

        if (savedImage != null) {
            val builder = AlertDialog.Builder(this@DrawingPadActivity)
            builder.setTitle("Saved")
                .setMessage("Saved Successfully. Dou you want to clear the canvas?")
                .setPositiveButton("Yes") { _, _ -> drawingPad!!.clearAll() }
                .setNegativeButton("No") { dialogInterface, _ -> dialogInterface.dismiss() }
            val n = builder.create()
            n.show()
        }

        drawingPad!!.destroyDrawingCache()
    }

}
