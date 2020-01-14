package com.example.qbittest.helper

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.example.qbittest.R
import java.io.IOException


class Util {
    companion object {
        fun inputStreamToString(context: Context, resId: Int): String? {
            val inputStream = context.resources.openRawResource(resId)
            return try {
                val bytes = ByteArray(inputStream.available())
                inputStream.read(bytes, 0, bytes.size)
                String(bytes)
            } catch (e: IOException) {
                null
            }
        }

        @SuppressLint("CheckResult")
        fun getRequestOption(): RequestOptions {
            val requestOptions = RequestOptions()
            requestOptions.placeholder(R.color.light_transparent)
            requestOptions.error(R.color.black)

            return requestOptions
        }

        fun imageViewAnimatedChange(
            c: Context?,
            v: ImageView,
            new_image: Drawable
        ) {
            val oldDrawable = v.drawable
            val anim_out: Animation = AnimationUtils.loadAnimation(c, R.anim.fade_out)
            val anim_in: Animation = AnimationUtils.loadAnimation(c, R.anim.fade_in)
            anim_out.setAnimationListener(object : AnimationListener {
                override fun onAnimationStart(animation: Animation) {
                    v.setOnClickListener(null)
                }
                override fun onAnimationRepeat(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    v.setImageDrawable(new_image)
                    anim_in.setAnimationListener(object : AnimationListener {
                        override fun onAnimationStart(animation: Animation) {}
                        override fun onAnimationRepeat(animation: Animation) {}
                        override fun onAnimationEnd(animation: Animation) {
                            v.setOnClickListener {
                                imageViewAnimatedChange(c,v,oldDrawable)
                            }
                        }
                    })
                    v.startAnimation(anim_in)
                }
            })
            v.startAnimation(anim_out)
        }

    }
}