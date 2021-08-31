package com.example.comeoneinstein.ui.activity

import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun initListener() {
        super.initListener()

        navigationListener()
    }

    private fun navigationListener(){
        register_toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}