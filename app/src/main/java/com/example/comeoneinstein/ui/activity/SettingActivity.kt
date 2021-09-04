package com.example.comeoneinstein.ui.activity

import android.preference.PreferenceManager
import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseActivity
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : BaseActivity(){
    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }



    override fun initData() {

        //获取推送通知有没有选中
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        val push = sp.getBoolean("push",false)
        println("push=$push")

    }

    override fun initListener() {
        super.initListener()
        setting_toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}