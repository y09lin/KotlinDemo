package com.huim.demo.kotlin.util

import android.content.Context
import android.content.Intent

/**
 * Intent
 * Created by huim_lin on 2017/6/7.
 */
object IntentUtils {
    fun go2GankMain(context: Context){
        val intent= Intent(context, Class.forName("com.huim.demo.kotlin.gank.activity.GankMain"))
        context.startActivity(intent)
    }

    fun go2PhoneStatus(context: Context){
        val intent= Intent(context, Class.forName("com.huim.demo.kotlin.phone.activity.PhoneStatusActivity"))
        context.startActivity(intent)
    }

    fun go2Activity(context: Context,className: String){
        val intent=Intent(context, Class.forName(className))
        context.startActivity(intent)
    }

    fun go2Activity(context: Context,cls:Class<*>){
        context.startActivity(Intent(context,cls))
    }
}