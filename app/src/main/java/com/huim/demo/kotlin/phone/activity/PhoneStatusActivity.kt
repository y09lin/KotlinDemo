package com.huim.demo.kotlin.phone.activity

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.util.Log
import com.huim.demo.kotlin.R
import com.huim.demo.kotlin.util.DeLog
import com.huim.demo.kotlin.util.ToastUtils
import kotlinx.android.synthetic.main.act_phone_status.*
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class PhoneStatusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_phone_status)
        val c=this

        val manager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        manager.listen(object : PhoneStateListener() {
            override fun onCallStateChanged(state: Int, incomingNumber: String) {
                super.onCallStateChanged(state, incomingNumber)
                text_phone_status.text="TEL:$incomingNumber \nState:$state"
//                DeLog.d("TEL:$incomingNumber \nState:$state")
                Log.d("Tel","TEL:$incomingNumber \nState:$state")
                ToastUtils.showMessage(c,"TEL:$incomingNumber \nState:$state")
                checkNetWork()
                check("http://www.baidu.com")
            }
        }, PhoneStateListener.LISTEN_CALL_STATE)
    }

    fun check(urlStr: String) {
        object : Thread() {
            override fun run() {
                try {
                    val url = URL(urlStr)
                    val uc = url.openConnection()
                    uc.connect()
                    val ld = uc.date
                    val format = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                    val date = Date(ld)
                    val t=format.format(date)
                    Log.d("Tel","$urlStr 接通网络时间:$t")
                } catch (e: Exception) {
                    DeLog.d("$urlStr 网络不通")
                    Log.d("Tel","$urlStr 网络不通")
                    e.printStackTrace()
                }

            }
        }.start()
    }

    fun checkNetWork() {
        val connectMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectMgr.activeNetworkInfo
        if (info == null) {
            Log.d("Tel","网络状态:无网络连接")
        } else {
            when (info.type) {
                ConnectivityManager.TYPE_WIFI -> {
                }
                ConnectivityManager.TYPE_MOBILE -> {
                    val tn = info.typeName + info.subtypeName
                    Log.d("Tel","网络状态:$tn")
                }
            }
        }
    }
}
