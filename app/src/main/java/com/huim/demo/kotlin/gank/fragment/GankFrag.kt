package com.huim.demo.kotlin.gank.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huim.demo.kotlin.R

/**
 * gank fragment
 * Created by huim_lin on 2017/6/16.
 */
class GankFrag :Fragment(){
    companion object{
        public val GANK_TYPE="gank_type"
        fun newInstance(context:Context,name:String,arg:Bundle):GankFrag{
            val f=GankFrag()
            f.arguments=arg
            return f
        }
    }

    private var mType:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.frag_gank, container, false)
    }
}