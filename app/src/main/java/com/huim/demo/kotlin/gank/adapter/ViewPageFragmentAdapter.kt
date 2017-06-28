package com.huim.demo.kotlin.gank.adapter

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.huim.demo.kotlin.gank.fragment.GankFrag

/**
 * gank tab adapter
 * Created by huim_lin on 2017/6/15.
 */
class ViewPageFragmentAdapter(fm: FragmentManager?,context: Context) : FragmentStatePagerAdapter(fm) {
    var mContext:Context = context
    private var mTabs:MutableList<TabPageInfo> = ArrayList()

    override fun getCount(): Int {
        return mTabs.size
    }

    override fun getItem(position: Int): Fragment {
        val info:TabPageInfo=mTabs.get(position)
        return GankFrag.newInstance(mContext,info.title,info.args)
    }

    fun addTab(title: String,clazz: Class<*>,args: Bundle){
        mTabs.add(TabPageInfo(title,clazz,args))
    }

    private inner class TabPageInfo(val title:String,val clazz:Class<*>, val args:Bundle)
}