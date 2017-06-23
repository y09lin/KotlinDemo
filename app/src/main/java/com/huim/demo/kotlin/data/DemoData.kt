package com.huim.demo.kotlin.data

import com.huim.demo.kotlin.R
import com.huim.demo.sherlockadapter.BaseViewHolder
import com.huim.demo.sherlockadapter.IFullSpan
import com.huim.demo.sherlockadapter.IMultiItem

/**
 * demos
 * Created by huim_lin on 2017/6/23.
 */
class DemoData(var name:String,var clazz:String, private val mSpanSize:Int):IMultiItem,IFullSpan{
    override fun isFullSpan(): Boolean {
        return false
    }

    override fun getLayoutRes(): Int {
        return R.layout.item_demo
    }

    override fun convert(holder: BaseViewHolder?) {
        holder!!.setText(R.id.text_demo,name)
    }

    override fun getSpanSize(): Int {
        return mSpanSize
    }

    fun getClass():String{
        return clazz
    }
}