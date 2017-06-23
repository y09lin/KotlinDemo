package com.huim.demo.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.huim.demo.kotlin.R
import com.huim.demo.kotlin.adapter.MainListAdapter
import com.huim.demo.kotlin.data.DemoData
import com.huim.demo.kotlin.util.IntentUtils
import com.huim.demo.sherlockadapter.IMultiItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mGridLayoutManager:GridLayoutManager?=null
    var mAdapter:MainListAdapter?=null
    var demoClass:Array<String> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mGridLayoutManager= GridLayoutManager(this,3)
        list.layoutManager=mGridLayoutManager
        mAdapter= MainListAdapter()
        list.adapter=mAdapter
        initGridData()
        bindEvents()
    }

    private fun bindEvents() {
        mAdapter!!.setOnItemClickListener({ _, adapterPosition ->
            IntentUtils.go2Activity(this,demoClass!![adapterPosition])
        })
    }

    fun initGridData(){
        val demoNames=resources.getStringArray(R.array.demo_names)
        demoClass=resources.getStringArray(R.array.demo_class)
        val demos= ArrayList<IMultiItem>()
        demoNames.indices.mapTo(demos) { DemoData(demoNames[it],demoClass!![it], it % 3 + 1) }
        mAdapter!!.data= demos
    }
}
