package com.example.comeoneinstein.ui.activity

import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseActivity
import kotlinx.android.synthetic.main.activity_smslogin.*

class SMSLoginActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_smslogin
    }

    override fun initListener() {
        SMSLogin_phoneNumber.setOnClickListener {
            startNextActivity<PhoneNumberLoginActivity>()
        }
    }

}
