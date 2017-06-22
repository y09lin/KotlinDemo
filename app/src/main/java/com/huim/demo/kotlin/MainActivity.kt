package com.huim.demo.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.huim.demo.kotlin.util.IntentUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        IntentUtils.go2Activity(this,"com.huim.demo.kotlin.flotview.Floatinglauncher")
    }


}
