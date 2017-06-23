package com.huim.demo.kotlin.flotview

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.huim.demo.kotlin.R
import kotlinx.android.synthetic.main.act_float_launcher.*

/**
 * Floating launcher
 * Created by huim_lin on 2017/6/22.
 */
class Floatinglauncher : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_float_launcher)
        initViews()
    }

    private fun initViews() {
        btn_start.setOnClickListener {
            startService(Intent(this, FloatingService::class.java))
        }
        btn_stop.setOnClickListener {
            stopService(Intent(this, FloatingService::class.java))
        }
        btn_config.setOnClickListener {
            stopService(Intent(this, FloatingService::class.java))
            startActivity(Intent(this, ConfigActivity::class.java))
        }
    }
}