package com.huim.demo.kotlin.flotview

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.IBinder
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import com.huim.demo.kotlin.R

/**
 * Floating launcher service
 * Created by huim_lin on 2017/6/22.
 */
class FloatingService : Service(){
    var chatHead:ImageView?=null
    val wm=getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val params=WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_PHONE,WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT)

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        showFloat()
    }

    private fun showFloat() {
        chatHead= ImageView(this)
        chatHead!!.setImageResource(R.mipmap.floating2)
        params.gravity=Gravity.TOP or Gravity.LEFT
        params.x=0
        params.y=100
        wm.addView(chatHead,params)

        chatHead!!.setOnTouchListener(onTouchListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (chatHead!=null) wm.removeView(chatHead)
    }

    private object onTouchListener : View.OnTouchListener{
        private var initialX: Int = 0
        private var initialY: Int = 0
        private var initialTouchX: Float = 0.toFloat()
        private var initialTouchY: Float = 0.toFloat()
        override fun onTouch(v: View?, event: MotionEvent?): Boolean {
            return false
        }

    }
}