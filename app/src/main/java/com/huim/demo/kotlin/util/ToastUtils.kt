package com.huim.demo.kotlin.util

import android.content.Context
import android.widget.Toast

/**
 * show toast
 * Created by huim_lin on 2017/5/23.
 */
object ToastUtils {
    fun showMessage(context: Context, str:String){
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show()
    }
}