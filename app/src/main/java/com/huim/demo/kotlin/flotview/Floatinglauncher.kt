package com.huim.demo.kotlin.flotview

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.huim.demo.kotlin.R
import kotlinx.android.synthetic.main.act_float_launcher.*

/**
 * Floating launcher
 * Created by huim_lin on 2017/6/22.
 */
class Floatinglauncher : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.act_float_launcher)
        initViews()
    }

    private fun initViews() {
        btn_start.setOnClickListener {
            startService(Intent(this, Class.forName("com.huim.demo.kotlin.flotview.FloatingService")))
        }
        btn_stop.setOnClickListener {
            stopService(Intent(this, Class.forName("com.huim.demo.kotlin.flotview.FloatingService")))
        }
        btn_config.setOnClickListener {
            stopService(Intent(this, Class.forName("com.huim.demo.kotlin.flotview.FloatingService")))
            startActivity(Intent(this, Class.forName("com.huim.demo.kotlin.flotview.ConfigActivity")))
        }
    }
}