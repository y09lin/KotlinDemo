package com.huim.demo.kotlin.gank.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huim.demo.kotlin.R
import com.huim.demo.kotlin.gank.adapter.ViewPageFragmentAdapter
import kotlinx.android.synthetic.main.frag_gank_tab.*

/**
 * gank首页
 */
class GankTab : Fragment() {

    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view=inflater!!.inflate(R.layout.frag_gank_tab, container, false)
        val adapter:ViewPageFragmentAdapter= ViewPageFragmentAdapter(childFragmentManager,context)
        try {
            pager_gank.adapter=adapter
            tab_gank.setupWithViewPager(pager_gank)

            val titles=resources.getStringArray(R.array.home_viewpage_arrays)
            titles.indices
                    .map { titles[it] }
                    .forEach { adapter.addTab(it,GankFrag::class.java,getBundle(it)) }
            pager_gank.offscreenPageLimit=titles.size
            adapter.notifyDataSetChanged()
        } catch(e: Exception) {
        }

        return view
    }

    fun getBundle(s:String):Bundle{
        val b=Bundle()
        b.putString(GankFrag.GANK_TYPE,s)
        return b
    }

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): GankTab {
            val fragment = GankTab()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}
