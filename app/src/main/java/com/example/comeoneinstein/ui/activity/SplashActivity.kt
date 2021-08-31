package com.example.comeoneinstein.ui.activity

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() ,ViewPropertyAnimatorListener{
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        //缩小动画
        ViewCompat.animate(imageView).scaleX(1.0f).scaleY(1.0f).setListener(this).duration = 2000
    }

    override fun onAnimationEnd(view: View?) {
        //动画结束进入登入
        startActivityAndFinish<HomeActivity>()

    }

    override fun onAnimationCancel(view: View?) {

    }

    override fun onAnimationStart(view: View?) {

    }

}