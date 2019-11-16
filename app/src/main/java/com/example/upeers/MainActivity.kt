package com.example.upeers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.upeers.coursepage.CoursePageActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import com.example.upeers.ui.login.LoginActivity
import com.example.upeers.ui.login.RegisterActivity
import android.animation.ObjectAnimator
import android.animation.AnimatorSet
import android.view.animation.BounceInterpolator
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.util.DisplayMetrics
import android.os.Build
import android.app.ActivityOptions

class MainActivity : AppCompatActivity() {

    private var width : Float = 0F
    private var height : Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = this.windowManager
        val outMetrics = DisplayMetrics()
        manager.defaultDisplay.getMetrics(outMetrics)
        width = outMetrics.widthPixels.toFloat()
        height = outMetrics.heightPixels.toFloat()

        val bootPic : ImageView = findViewById<ImageView>(R.id.start_img)

        startWidgetFadeAnim()
        startImgBounceAnim(bootPic)
    }

    private fun startImgBounceAnim(widget: View) {

        // fml, no idea how to force move a widget in constraint layout
        // workaround: use animation
        // at first, move the picture to the very top
        val originX : Float = widget.translationX;

        val anim1 = ObjectAnimator.ofFloat(widget, View.TRANSLATION_Y, originX, -height / 2)
        anim1.duration = 10
        anim1.addListener(object : Animator.AnimatorListener {

            // non-abstract -> have to give implementation for these functions
            override fun onAnimationStart(animation: Animator) {}

            override fun onAnimationEnd(animation: Animator) {
                widget.visibility = View.VISIBLE // picture is visible

                // init, shrink the size
                val anim2 = ObjectAnimator.ofFloat(widget, View.SCALE_X, 1F, 0.5F)
                val anim3 = ObjectAnimator.ofFloat(widget, View.SCALE_Y, 1F, 0.5F)

                val anim = AnimatorSet()
                anim.play(anim2).with(anim3)
                anim.duration = 10
                anim.addListener(object : AnimatorListenerAdapter() {

                    // override again as callback, inject main animation step
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)

                        // main animation
                        // note: only anim4 should be affected by the interpolator
                        val anim4 = ObjectAnimator.ofFloat(widget, View.TRANSLATION_Y, -height / 2, originX)
                        anim4.interpolator = BounceInterpolator()
                        val anim5 = ObjectAnimator.ofFloat(widget, View.ROTATION, 0F, -360F)
                        val anim6 = ObjectAnimator.ofFloat(widget, View.SCALE_X, 0.5F, 0.5F, 0.5F, 0.5F, 1F)
                        val anim7 = ObjectAnimator.ofFloat(widget, View.SCALE_Y, 0.5F, 0.5F, 0.5F, 0.5F, 1F)

                        val animMain = AnimatorSet()
                        animMain.duration = 2000
                        animMain.play(anim4).with(anim5).with(anim6).with(anim7)
                        animMain.start()
                    }
                })
                anim.start()
            }

            override fun onAnimationCancel(animation: Animator) {}

            override fun onAnimationRepeat(animation: Animator) {}
        })
        anim1.start()
    }

    fun onClickTemporaryButton2(view: View) {
        val intent = Intent(this, CoursePageActivity::class.java).apply {
        }
        startActivity(intent)
    }

    fun onClickSignUp(view: View) {
        startActivity(Intent(this, RegisterActivity::class.java).apply {})
    }

    private fun startWidgetFadeAnim() {

        val introText : TextView = findViewById<TextView>(R.id.text_get_started)
        val signInBtn : Button = findViewById<Button>(R.id.btn_login)
        val signUpBtn : Button = findViewById<Button>(R.id.btn_register)

        // the buttons will fade in after the text
        val anim1 = ObjectAnimator.ofFloat(introText, "alpha", 0F, 1F)
        val anim2 = ObjectAnimator.ofFloat(signInBtn, "alpha", 0F, 1F)
        val anim3 = ObjectAnimator.ofFloat(signUpBtn, "alpha", 0F, 1F)

        anim1.duration = 1000
        anim1.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}

                override fun onAnimationEnd(animation: Animator) {
                    signInBtn.visibility = View.VISIBLE
                    signUpBtn.visibility = View.VISIBLE

                    val anim = AnimatorSet()
                    anim.duration = 2000
                    anim.play(anim2).with(anim3)
                    anim.start()
                }

                override fun onAnimationCancel(animation: Animator) {}

                override fun onAnimationRepeat(animation: Animator) {}
            })
        anim1.start()
    }

    fun onClickSignIn(view: View) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            startActivity(Intent(this, LoginActivity::class.java).apply {})
        else
            startActivity(Intent(this, LoginActivity::class.java).apply {}, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    fun onClickSignUp(view: View) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            startActivity(Intent(this, RegisterActivity::class.java).apply {})
        else
            startActivity(Intent(this, RegisterActivity::class.java).apply {}, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }
}
