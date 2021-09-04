package com.example.comeoneinstein.ui.activity

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toolbar
import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    lateinit var sp : SharedPreferences
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData() {

    }

    override fun onResume() {
        //用户登入成功后
        super.onResume()
        val prefs = getSharedPreferences("ui.activity.PhoneNumberLoginActivity"
            ,Context.MODE_PRIVATE)
        val isLogin = prefs.getBoolean("isLoginReserved",false)
        Log.e("fff",prefs.toString())

        if(isLogin){
            Log.e("fff","finish")
            val editor = getSharedPreferences("ui.activity.PhoneNumberLoginActivity"
                ,Context.MODE_PRIVATE).edit()
            editor.putBoolean("isLoginReserved",false)
            //编辑完以后要加上 apply()!!!!!!!!!!
            editor.apply()
            finish()

        }
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