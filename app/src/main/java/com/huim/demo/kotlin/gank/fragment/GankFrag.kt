package com.huim.demo.kotlin.gank.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huim.demo.kotlin.R
import com.huim.demo.kotlin.adapter.MainListAdapter
import com.huim.demo.kotlin.gank.data.GankDate
import com.huim.demo.kotlin.gank.net.GankRequestUtils
import com.huim.demo.sherlockadapter.IMultiItem


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
    private var mAdapter:MainListAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mType=arguments.getString(GANK_TYPE)
        val view=inflater!!.inflate(R.layout.frag_gank, container, false)
        val list=view.findViewById(R.id.list)as RecyclerView
        val mGridLayoutManager= GridLayoutManager(activity,1)
        list.layoutManager=mGridLayoutManager
        mAdapter= MainListAdapter()
        list.adapter=mAdapter
        getData()
        return view
    }

    private fun getData() {
        GankRequestUtils.requestGankByType(activity,mType!!,1,object:GankRequestUtils.GankTypeListener{
            override fun onError() {
            }

            override fun onGetData(list: List<IMultiItem>) {
                mAdapter!!.data=list

                list.indices
                        .map { list[it] as GankDate }
                        .forEach { Log.d("Gank", it.desc) }
            }

        })
    }
}