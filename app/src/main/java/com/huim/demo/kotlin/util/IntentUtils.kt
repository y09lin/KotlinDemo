package com.huim.demo.kotlin.util

import android.content.Context
import android.content.Intent

/**
 * Intent
 * Created by huim_lin on 2017/6/7.
 */
object IntentUtils {
    fun go2GankMain(context: Context){
        var intent= Intent(context, Class.forName("com.huim.demo.kotlin.phone.activity.PhoneStatusActivity"))
        context.startActivity(intent)
    }
}