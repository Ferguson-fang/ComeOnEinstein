package com.example.comeoneinstein.ui.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProviders
import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseActivity
import com.example.comeoneinstein.model.User
import com.example.comeoneinstein.util.UserViewModelFactory
import kotlinx.android.synthetic.main.activity_phonenumberlogin.*

class PhoneNumberLoginActivity : BaseActivity() {
    lateinit var userViewModel : User
    lateinit var sp : SharedPreferences
    override fun getLayoutId(): Int {
        return R.layout.activity_phonenumberlogin
    }

    override fun initData() {
        super.initData()
        initSP()

        if(userViewModel.isRemember){
            perWriteIn()
        }
    }

    override fun initListener() {
        phoneNumberLogin_SMS.setOnClickListener {
            startNextActivity<SMSLoginActivity>()
        }
        navigationListener()
        loginBtnListener()

    }

    private fun navigationListener() {
        phoneNumber_toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun initSP(){
        //getPreferences()方法自动将当前的类名作为生成的文件名
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getString("countReserved","")
        val passwordReserved = sp.getString("passwordReserved","")
        val isRememberReserved = sp.getBoolean("isRememberReserved",false)
        val isLogin = sp.getBoolean("isLoginReserved",false)
        userViewModel = ViewModelProviders.of(this,UserViewModelFactory
            (countReserved.toString(), passwordReserved.toString(),isRememberReserved,isLogin)).get(User::class.java)

    }

    private fun perWriteIn(){
        phoneNumberLogin_phone.setText(userViewModel.count)
        phoneNumberLogin_password.setText(userViewModel.password)
    }

    private fun loginBtnListener(){
        phoneNumberLogin_loginBtn.setOnClickListener {
            if("" == phoneNumberLogin_phone.text.toString()
                || "" == phoneNumberLogin_password.text.toString()){
                Toast.makeText(this,"登入失败，用户名或密码为空",
                    Toast.LENGTH_SHORT).show()
            }else {
                if("19823690607" == phoneNumberLogin_phone.text.toString()
                    &&"160506" == phoneNumberLogin_password.text.toString()){
                    //用户名密码正确
                    userViewModel.count = phoneNumberLogin_phone.text.toString()
                    userViewModel.password = phoneNumberLogin_password.text.toString()
                    userViewModel.isLogin = true
                    userViewModel.isRemember = phoneNumberLogin_checkbox.isChecked

                    sp.edit{
                        putString("countReserved",userViewModel.count)
                        putString("passwordReserved",userViewModel.password)
                        putBoolean("isRememberReserved",userViewModel.isRemember)
                        putBoolean("isLoginReserved",userViewModel.isLogin)
                    }
                    finish()
                }else {
                    //用户名密码错误
                    Toast.makeText(this,"登入失败，用户不存在或密码不正确",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
