package com.huim.demo.kotlin.gank.fragment

import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * gank fragment
 * Created by huim_lin on 2017/6/16.
 */
class GankFrag :Fragment(){
    companion object{
        public val GANK_TYPE="gank_type"
    }

    private var mType:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}