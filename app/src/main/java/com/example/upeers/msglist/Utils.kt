package com.sendbird.androidchattutorial


import android.content.Context
import android.graphics.Bitmap
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import android.widget.ImageView


import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget

import java.text.SimpleDateFormat
import java.util.Locale

//import sun.security.krb5.internal.KDCOptions.with

object Utils {

    /**
     * Gets timestamp in millis and converts it to HH:mm (e.g. 16:44).
     */
    fun formatTime(timeInMillis: Long): String {
        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        return dateFormat.format(timeInMillis)
    }

    /**
     * Crops image into a circle that fits within the ImageView.
     * Deprecated!!!
     */
    fun displayRoundImageFromUrl(context: Context, url: String, imageView: ImageView) {
        Glide.with(context)
            .asBitmap()
            .centerCrop()
            .dontAnimate()
            .into(object : BitmapImageViewTarget(imageView) {
                override fun setResource(resource: Bitmap?) {
                    val circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.resources, resource)
                    circularBitmapDrawable.isCircular = true
                    imageView.setImageDrawable(circularBitmapDrawable)
                }
            })
    }

}
