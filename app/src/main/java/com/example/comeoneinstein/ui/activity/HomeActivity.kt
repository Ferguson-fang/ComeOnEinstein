package com.example.comeoneinstein.ui.activity

import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseActivity
import com.example.comeoneinstein.util.FragmentUtil.Companion.fragmentUtil
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initListener() {
        //设置tab切换监听
        bottomBar.setOnTabSelectListener {
            /**
             * 问题：在一个容器内嵌套两个fragment
             * 当切换回第一个外层的Fragment时，报错Fragment no longer exists for key f0: index 0
             * */
            //it代表ID
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragmentUtil.getFragment(it)!!,it.toString())
            transaction.commit()
        }
    }
}