package com.huim.demo.kotlin.gank.data

import android.text.TextUtils
import android.view.View
import com.bumptech.glide.Glide
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
        if (TextUtils.isEmpty(who)){
            holder.setVisibility(R.id.tv_home_gank_author, View.GONE)
        }else{
            holder.setText(R.id.tv_home_gank_author,who)
            holder.setVisibility(R.id.tv_home_gank_author, View.VISIBLE)
        }
        val time=publishedAt!!.split("T")[0]
        holder.setText(R.id.tv_home_gank_date,time)
        if (images!=null && images!!.isNotEmpty()){
            holder.setVisibility(R.id.iv_home_gank_img, View.VISIBLE)
            val iv=holder.findImage(R.id.iv_home_gank_img)
            val imageUrl=images!![0]
            Glide.with(iv)
                    .load("$imageUrl?imageView2/0/w/400")
                    .into(iv)

//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .error(R.color.accent)
//                    .crossFade()
//                    .into
        }else{
            holder.setVisibility(R.id.iv_home_gank_img, View.GONE)
        }
    }

    override fun getSpanSize(): Int {
        return 1
    }
}