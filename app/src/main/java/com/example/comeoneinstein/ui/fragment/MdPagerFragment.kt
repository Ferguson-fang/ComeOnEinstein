package com.example.comeoneinstein.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.example.comeoneinstein.base.BaseActivity
import com.example.comeoneinstein.base.BaseFragment

class MdPagerFragment : BaseFragment() {
    override fun initView(): View? {
        val tv = TextView(context)
        tv.gravity = Gravity.CENTER
        tv.setTextColor(Color.RED)
        tv.text = javaClass.simpleName
        return tv
    }

}
