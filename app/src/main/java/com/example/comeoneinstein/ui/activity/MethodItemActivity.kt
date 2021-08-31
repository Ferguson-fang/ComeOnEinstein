package com.example.comeoneinstein.ui.activity

import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseActivity
import kotlinx.android.synthetic.main.activity_method.*

class MethodItemActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_method
    }

    override fun initData() {
        super.initData()
    }


    override fun initListener() {
        method_item_toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}