package com.example.comeoneinstein.util

import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseFragment
import com.example.comeoneinstein.ui.fragment.*

/**
 * 管理fragment的util类
 * */
class FragmentUtil private constructor(){//私有化构造方法
    private val commendFragment by lazy { CommendFragment() }
    private val courseFragment by lazy { CourseFragment() }
    private val addFragment by lazy { AddFragment() }
    private val markdownFragment by lazy { MarkdownFragment() }
    private val mineFragment by lazy { MineFragment() }
    companion object{
    /**
     * 单例类
     * by lazy懒加载，创建时只创建一次
     * 且线程安全
     * */
        val fragmentUtil by lazy { FragmentUtil() }
    }
    /**
     * 根据tabid获取对应的fragment
     * */
    fun getFragment(tabId : Int) : BaseFragment?{
        when(tabId){
            R.id.tab_home -> return commendFragment
            R.id.tab_course -> return courseFragment
            R.id.tab_add -> return addFragment
            R.id.tab_markdown -> return markdownFragment
            R.id.tab_mine -> return mineFragment
        }
        return null
    }

}