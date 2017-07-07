
package com.huim.demo.kotlin.gank.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.huim.demo.kotlin.R
import kotlinx.android.synthetic.main.act_gank_web.*

/**
 * gank web
 * Created by huim_lin on 2017/6/30.
 */
class GankWeb : AppCompatActivity() {
    companion object{
        val STR_URL="str_url"
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_gank_web)

        val strUrl=intent.getStringExtra(STR_URL)
        Log.d("Gank",strUrl)
        web_gank.loadUrl(strUrl)
        web_gank.settings.javaScriptEnabled=true
        web_gank.setWebChromeClient(object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                progress_gank.visibility= View.VISIBLE
                progress_gank.progress = newProgress
            }
        })
        web_gank.setWebViewClient(object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progress_gank.visibility= View.GONE
            }
        })
    }

    override fun onBackPressed() {
        if (web_gank.canGoBack()){
            web_gank.goBack()
        }else{
            super.onBackPressed()
        }
    }
}