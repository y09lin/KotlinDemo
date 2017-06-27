package com.huim.demo.kotlin.gank.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huim.demo.kotlin.R
import com.huim.demo.kotlin.gank.adapter.ViewPageFragmentAdapter

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
            val titles=resources.getStringArray(R.array.home_viewpage_arrays)
            for (i in titles.indices){
                adapter.addTab(titles[i],GirlFrag::class.java,getBundle(titles[i]))
            }
            val pager_gank= view.findViewById(R.id.pager_gank) as ViewPager
            val tab_gank=view.findViewById(R.id.tab_gank) as TabLayout
            pager_gank.adapter=adapter
            pager_gank.offscreenPageLimit=titles.size
            tab_gank.setupWithViewPager(pager_gank)
            adapter.notifyDataSetChanged()
            var i=0
            while (i<tab_gank.tabCount){
                val tab:TabLayout.Tab= tab_gank.getTabAt(i)!!
                tab.text = titles[i]
                i++
            }
        } catch(e: Exception) {
            e.printStackTrace()
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
