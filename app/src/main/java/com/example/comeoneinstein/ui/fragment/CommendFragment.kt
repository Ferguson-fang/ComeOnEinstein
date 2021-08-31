package com.example.comeoneinstein.ui.fragment

import android.os.Parcelable
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_commend.*

class CommendFragment : BaseFragment(){
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_commend,null)
    }

    override fun initData() {


        commend_viewPager2.isSaveEnabled = false
        commend_viewPager2.adapter = object : FragmentStateAdapter(this!!.activity!!){

            override fun getItemCount() = 3
            //告诉ViewPager里面有几个页面

            override fun createFragment(position: Int)=
                //内容和页面对应
                when(position){
                    0 -> VideoCommendFragment()
                    1 -> MethodCommendFragment()
                    else -> MarkdownCommendFragment()
                }
        }

        TabLayoutMediator(commend_tabLayout,commend_viewPager2){tab, position ->
            when(position) {
                0 -> tab.text = "精华课程视频"
                1 -> tab.text = "学霸高效方法"
                else -> tab.text = "精华学霸笔记"
            }
        }.attach()
    }

    override fun initListener() {
        super.initListener()
    }

}
