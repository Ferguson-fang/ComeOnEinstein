package com.example.comeoneinstein.ui.fragment

import android.content.Intent
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseFragment
import com.example.comeoneinstein.ui.activity.*
import kotlinx.android.synthetic.main.fragment_mine.*

class MineFragment : BaseFragment(){
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_mine,null)
    }


    override fun initListener() {
        mine_publish.setOnClickListener {
            val intent = Intent(context, MyPublishActivity::class.java)
            startActivity(intent)
        }
        initLoginListener()
        mine_setting.setOnClickListener {
            val intent = Intent(context, SettingActivity::class.java)
            startActivity(intent)
        }
        mine_favorite.setOnClickListener {
            val intent = Intent(context,MyFavoriteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initLoginListener(){
        mine_name.setOnClickListener {
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }
        mine_image.setOnClickListener {
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}
