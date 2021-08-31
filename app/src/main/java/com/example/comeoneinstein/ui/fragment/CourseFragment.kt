package com.example.comeoneinstein.ui.fragment

import android.view.View
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_course.*

class CourseFragment : BaseFragment(){
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_course,null)
    }

    override fun initData() {
        //Fragment中嵌套Fragment需要传入childFragmentManager
        course_viewPager2.adapter = object : FragmentStateAdapter(this!!.activity!!){
            override fun getItemCount() = 3
            //告诉ViewPager里面有几个页面

            override fun createFragment(position: Int)=
                //内容和页面对应
                when(position){
                    0 -> CourseMyLikeFragment()
                    1 -> CourseMyFavoriteFragment()
                    else -> CourseRecordsFragment()
                }
        }
        TabLayoutMediator(course_tabLayout,course_viewPager2){tab, position ->
            when(position) {
                0 -> tab.text = "我的点赞"
                1 -> tab.text = "我的收藏"
                else -> tab.text = "浏览记录"
            }
        }.attach()

    }

    override fun initListener() {
        super.initListener()
    }

}
