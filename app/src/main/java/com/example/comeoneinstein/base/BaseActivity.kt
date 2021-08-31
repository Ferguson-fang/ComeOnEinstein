package com.example.comeoneinstein.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast

/**
 * ClassName: BaseActivity
 * Description:所有Activity的基类
 * */

 abstract class BaseActivity : AppCompatActivity(),AnkoLogger/*继承AnkoLogger用于日至打印*/{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

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

    /**
     * 获取布局ID
     * */
    abstract fun getLayoutId(): Int

    /**
     * anko 库中toast()方法没有处理线程问腿，在子线程使用有威胁
     * 调用myToast方法可解决该问题
     * */
    protected fun myToast(msg: String){
        runOnUiThread { toast(msg) }
    }

    /**
     *每调用一次Lambda表达式，都会创建一个新的匿名类实例，当然也会造成额外的内存和性能的开销
     *
     * 内敛函数可以解决改问题
     */

    /**
     * 打开下一个Activity并finish当前界面
     * */

    inline fun <reified T: BaseActivity>startActivityAndFinish() {
        val intent = Intent(this, T::class.java)
        startActivity(intent)
        finish()
    }
    inline fun <reified T: BaseActivity>startNextActivity() {
        val intent = Intent(this, T::class.java)
        startActivity(intent)
    }
}