package com.example.comeoneinstein.ui.activity

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comeoneinstein.MyApplication
import com.example.comeoneinstein.R
import com.example.comeoneinstein.adapter.CommendVideoAdapter
import com.example.comeoneinstein.base.BaseActivity
import com.example.comeoneinstein.bean.CommendMethodItemBean
import com.example.comeoneinstein.bean.CommendVideoItemBean
import kotlinx.android.synthetic.main.activity_method.*
import kotlinx.android.synthetic.main.activity_videoitem.*

class VideoItemActivity : BaseActivity() {
    private val list = listOf(
        CommendVideoItemBean("方法名称","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        CommendVideoItemBean("方法名称","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        CommendVideoItemBean("方法名称","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        CommendVideoItemBean("方法名称","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        CommendVideoItemBean("方法名称","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        CommendVideoItemBean("方法名称","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0")
    )
    override fun getLayoutId(): Int {
        return R.layout.activity_videoitem
    }

    override fun initData() {
        super.initData()
        initRv()
    }
    override fun initListener() {
        video_back_iv.setOnClickListener {
            finish()
        }
    }


    private fun initRv(){
        video_item_rv.layoutManager = LinearLayoutManager(MyApplication.context,LinearLayoutManager.HORIZONTAL,false)
        video_item_rv.adapter = CommendVideoAdapter(list)
    }

}
