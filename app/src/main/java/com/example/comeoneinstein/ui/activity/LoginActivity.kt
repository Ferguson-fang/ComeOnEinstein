package com.example.comeoneinstein.ui.activity

import android.widget.Toolbar
import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData() {

    }

    override fun initListener() {
        navigationListener()
        registerBottomListener()
        loginButtonListener()
    }

    private fun loginButtonListener() {
        login_button.setOnClickListener {
            startNextActivity<PhoneNumberLoginActivity>()
        }
    }

    private fun navigationListener(){
        login_toolbar.setNavigationOnClickListener {
            finish()
        }
    }
    private fun registerBottomListener(){
        login_textView.setOnClickListener {
            startNextActivity<RegisterActivity>()
        }
    }
}