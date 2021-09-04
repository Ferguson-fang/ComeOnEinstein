package com.example.comeoneinstein.model

import androidx.lifecycle.ViewModel

class User(countReserved: String,passwordReserved: String
           ,isRememberReserved: Boolean,isLogin : Boolean) : ViewModel() {
    /**
     * 在Kotlin中，getter和setter是可选的，如果你没有在代码中创建它们，它是会默认自动生成
     * */
    var count = countReserved

    var password = passwordReserved

    var isRemember = isRememberReserved

    var isLogin = isLogin

}