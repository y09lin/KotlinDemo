package com.huim.demo.kotlin.gank.net

import android.app.Activity
import android.util.Log
import com.google.gson.Gson
import com.huim.demo.kotlin.data.GankRequestResult
import com.huim.demo.sherlockadapter.IMultiItem
import okhttp3.*
import java.io.IOException

/**
 * gank request
 * Created by huim_lin on 2017/6/28.
 */
object GankRequestUtils{
    val mBaseUrl ="http://gank.io/api/data"
    val mCount =10
//    val mBaseUrl="http://gank.io/api/data/Android/10/1"

    interface GankTypeListener{
        fun onGetData(list:List<IMultiItem>)
        fun onError()
    }

    fun requestGankByType(avtivity: Activity, type:String, count:Int, page:Int, listener:GankTypeListener){
        var num=count
        if (num<=0){
            num = mCount
        }
        val url="$mBaseUrl/$type/$num/$page"
        Log.d("Gank","Get Gank list by type's url: $url")
        val client=OkHttpClient()
        val request=Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                avtivity.runOnUiThread {
                    listener.onError()
                }
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                val result=response.body()!!.string()
                val gson=Gson()
                val gank=gson.fromJson(result,GankRequestResult::class.java)
                val list=gank.results
                if (list!=null){
                    avtivity.runOnUiThread {
                        listener.onGetData(list)
                    }
                }
            }
        })
    }

}