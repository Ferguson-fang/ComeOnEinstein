package com.example.comeoneinstein.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.support.v4.runOnUiThread
import org.jetbrains.anko.support.v4.toast

/**
 * ClassName: BaseFragment
 * Description:所有Fragment的基类
 * */
abstract class BaseFragment : Fragment() ,AnkoLogger{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initView()
    }

    /**
     * 获取布局id
     * */
    abstract fun initView(): View?

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }

    /**
     * 初始化数据
     * */
    open fun initData() {
    }

    /**
     * 与adapter和listener相关的操作
     * */
    open fun initListener() {

    }

    open fun init() {

    }

    /**
     * anko 库中toast()方法没有处理线程问腿，在子线程使用有威胁
     * 调用myToast方法可解决该问题
     * */
    fun myToast(msg: String){
        runOnUiThread { toast(msg) }
    }




}