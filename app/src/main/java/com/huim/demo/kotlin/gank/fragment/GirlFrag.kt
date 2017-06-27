package com.huim.demo.kotlin.gank.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huim.demo.kotlin.R

/**
 * 阅读
 * Created by huim_lin on 2017/6/8.
 */
class GirlFrag :Fragment(){
    private var mParam1: String? = null
    companion object {
        private val ARG_PARAM1 = "param1"

        fun newInstance(param1: String, param2: String): GirlFrag {
            val fragment = GirlFrag()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.frag_gank_girl, container, false)
    }
}