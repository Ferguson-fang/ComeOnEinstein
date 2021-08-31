package com.example.comeoneinstein.ui.activity

import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseActivity
import kotlinx.android.synthetic.main.activity_phonenumberlogin.*

class PhoneNumberLoginActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_phonenumberlogin
    }

    override fun initListener() {
        phoneNumberLogin_SMS.setOnClickListener {
            startNextActivity<SMSLoginActivity>()
        }
        navigationListener()

    }

    private fun navigationListener() {
        phoneNumber_toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}
