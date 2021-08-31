package com.example.comeoneinstein

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    //因为application在整个项目里是唯一的 获得全局上下文
    override fun onCreate() {
        super.onCreate()
        context= applicationContext
    }

    companion object {
        lateinit var context: Context
    }
}