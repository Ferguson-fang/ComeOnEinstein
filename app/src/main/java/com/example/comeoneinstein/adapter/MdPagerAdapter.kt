package com.example.comeoneinstein.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.comeoneinstein.ui.fragment.MdPagerFragment

class MdPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
    override fun getItem(position: Int): Fragment {
        return MdPagerFragment()
    }

    override fun getCount(): Int {
        //不为空放回list.size，如果为空返回0
        return 3
    }
}