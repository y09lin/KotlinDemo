package com.huim.demo.kotlin.flotview

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.PixelFormat
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import com.huim.demo.kotlin.R
import com.huim.demo.kotlin.util.ToastUtils

/**
 * Floating launcher service
 * Created by huim_lin on 2017/6/22.
 */
class FloatingService : Service(){
    internal var lastPressTime: Long = 0
    var chatHead:ImageView?=null
    var wm:WindowManager?=null
    var params:WindowManager.LayoutParams?=null

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
        params=WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT)
        params!!.gravity=Gravity.TOP or Gravity.START
        params!!.x=0
        params!!.y=100
        wm=getSystemService(Context.WINDOW_SERVICE) as WindowManager
        wm!!.addView(chatHead,params)

        chatHead!!.setOnTouchListener(onTouchListener)
        chatHead!!.setOnClickListener {
            initPop()
        }
    }

    private fun initPop(){
        ToastUtils.showMessage(this,"OnClick")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (chatHead!=null) wm!!.removeView(chatHead)
    }

    private val onTouchListener=object : View.OnTouchListener{
//        val param:WindowManager.LayoutParams = params!!
        private var initialX: Int = 0
        private var initialY: Int = 0
        private var initialTouchX: Float = 0.toFloat()
        private var initialTouchY: Float = 0.toFloat()

        override fun onTouch(v: View, event: MotionEvent): Boolean {
            when(event.action){
                MotionEvent.ACTION_DOWN->{
                    val pressTime = System.currentTimeMillis()
                    if (pressTime - lastPressTime <= 300) {
                        createNotification()
                        this@FloatingService.stopSelf()
//                        mHasDoubleClicked = true
                    } else {
//                        mHasDoubleClicked = false
                    }
                    lastPressTime = pressTime
                    initialX = params!!.x
                    initialY = params!!.y
                    initialTouchX = event.rawX
                    initialTouchY = event.rawY
                }
                MotionEvent.ACTION_MOVE->{
                    params!!.x = initialX + (event.rawX - initialTouchX).toInt()
                    params!!.y = initialY + (event.rawY - initialTouchY).toInt()
                    wm!!.updateViewLayout(chatHead, params)
                }
                MotionEvent.ACTION_UP->{}
            }
            return false
        }
    }

    fun createNotification(){
        val noteIntent=Intent(applicationContext, this.javaClass)
        val pendIntent=PendingIntent.getService(applicationContext,0,noteIntent,0)
        val builder=NotificationCompat.Builder(this)
                .setContentIntent(pendIntent)
                .setLargeIcon(BitmapFactory.decodeResource(resources,R.mipmap.floating5))
                .setSmallIcon(R.mipmap.floating2)
                .setWhen(System.currentTimeMillis())
                .setTicker("Click to start launcher")
                .setContentTitle("Floating launcher")
                .setContentText("Just click to see see")
        val noteManager=applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        noteManager.notify(2018,builder.build())
    }
}