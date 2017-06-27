package com.huim.demo.kotlin.gank.activity

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.huim.demo.kotlin.R
import com.huim.demo.kotlin.gank.fragment.GankTab
import com.huim.demo.kotlin.gank.fragment.GirlFrag
import com.huim.demo.kotlin.gank.fragment.MoveFrag
import com.huim.demo.kotlin.gank.fragment.ReadFrag
import kotlinx.android.synthetic.main.act_gank_main.*

class GankMain : AppCompatActivity() {
    var tagFrag:GankTab ? =null
    var readFrag:ReadFrag ? =null
    var girlFrag:GirlFrag ?= null
    var moveFrag:MoveFrag ?= null

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
            true
        }
        setDefaultFragment(0)
    }

    private fun  setDefaultFragment(i: Int) {
        val ft=supportFragmentManager.beginTransaction()
        hideFrag(ft)
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
                if (readFrag==null){
                    readFrag=ReadFrag.newInstance("","")
                    ft.add(R.id.layout_content,readFrag)
                }else{
                    ft.show(readFrag)
                }
            }
            2->{
                if (girlFrag==null){
                    girlFrag=GirlFrag.newInstance("","")
                    ft.add(R.id.layout_content,girlFrag)
                }else{
                    ft.show(girlFrag)
                }
            }
            3->{
                if (moveFrag==null){
                    moveFrag=MoveFrag.newInstance("","")
                    ft.add(R.id.layout_content,moveFrag)
                }else{
                    ft.show(moveFrag)
                }
            }
        }
        ft.commit()
    }

    fun hideFrag(ft: FragmentTransaction){
        if(tagFrag!=null){
            ft.hide(tagFrag)
        }
        if (readFrag!=null){
            ft.hide(readFrag)
        }
        if (girlFrag!=null){
            ft.hide(girlFrag)
        }
        if (moveFrag!=null){
            ft.hide(moveFrag)
        }
    }
}
