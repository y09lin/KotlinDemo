package com.huim.demo.kotlin.gank.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.huim.demo.kotlin.R
import com.huim.demo.kotlin.gank.fragment.GankTab
import kotlinx.android.synthetic.main.act_gank_main.*

class GankMain : AppCompatActivity() {
    var tagFrag:GankTab ? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_gank_main)
        initView()
    }

    private fun initView() {
        bn_gank_main.setOnNavigationItemSelectedListener {
            item ->
            when (item.itemId) {
                R.id.item_navigation_home -> {
                    setDefaultFragment(0)
                }
                R.id.item_navigation_read -> {
                    setDefaultFragment(1)
                }
                R.id.item_navigation_girl -> {
                    setDefaultFragment(2)
                }
                R.id.item_navigation_video -> {
                    setDefaultFragment(3)
                }
            }
            false
        }
        setDefaultFragment(0)
    }

    private fun  setDefaultFragment(i: Int) {
        val ft=supportFragmentManager.beginTransaction()
        when(i){
            0->{
                if (tagFrag==null){
                    tagFrag=GankTab.newInstance("","")
                    ft.add(R.id.layout_content,tagFrag)
                }else{
                    ft.show(tagFrag)
                }
            }
            1->{
                if (tagFrag==null){
                    tagFrag=GankTab.newInstance("","")
                    ft.add(R.id.layout_content,tagFrag)
                }else{
                    ft.show(tagFrag)
                }
            }
            2->{
                if (tagFrag==null){
                    tagFrag=GankTab.newInstance("","")
                    ft.add(R.id.layout_content,tagFrag)
                }else{
                    ft.show(tagFrag)
                }
            }
            3->{
                if (tagFrag==null){
                    tagFrag=GankTab.newInstance("","")
                    ft.add(R.id.layout_content,tagFrag)
                }else{
                    ft.show(tagFrag)
                }
            }
        }
        ft.commit()
    }
}
