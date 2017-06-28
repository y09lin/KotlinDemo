package com.huim.demo.kotlin.gank.data

import com.huim.demo.kotlin.R
import com.huim.demo.sherlockadapter.BaseViewHolder
import com.huim.demo.sherlockadapter.IFullSpan
import com.huim.demo.sherlockadapter.IMultiItem

/**
 * gank data
 * Created by huim_lin on 2017/6/27.
 */
class GankDate : IMultiItem, IFullSpan {
    var desc:String?= null
    var publishedAt:String?= null
    var url:String?= null
    var who:String?= null
    var images:List<String>? = null

    override fun isFullSpan(): Boolean {
        return true
    }

    override fun getLayoutRes(): Int {
        return R.layout.item_gank_list
    }

    override fun convert(holder: BaseViewHolder?) {
        holder!!.setText(R.id.tv_home_gank_title,desc)
        holder.setText(R.id.tv_home_gank_author,who)
        holder.setText(R.id.tv_home_gank_date,publishedAt)
    }

    override fun getSpanSize(): Int {
        return 1
    }
}