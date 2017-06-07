package com.huim.demo.kotlin.util

import android.util.Log

/**
 * debug
 * Created by huim_lin on 2017/5/23.
 */
object DeLog {
    var TAG="Kotlin"

    fun setTag(tag:String){
        TAG=tag
    }

    fun d(b:Boolean){
        Log.d(TAG,"$b")
    }

    fun d(n : Int){
        Log.d(TAG,"$n")
    }

    fun d(message:String){
        Log.d(TAG,message)
    }

    fun d(tag:String,message:Any){
        Log.d(tag,"$message")
    }
}