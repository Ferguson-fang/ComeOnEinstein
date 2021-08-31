package com.example.comeoneinstein.ui.activity

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comeoneinstein.R
import com.example.comeoneinstein.adapter.SubjectItemAdapter
import com.example.comeoneinstein.adapter.VideoAdapter
import com.example.comeoneinstein.base.BaseActivity
import com.example.comeoneinstein.bean.CommendMethodItemBean
import com.example.comeoneinstein.bean.ItemBean
import kotlinx.android.synthetic.main.activity_chinese.*

class ChineseActivity : BaseActivity(){
    private val list = listOf(
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0")
    )
    override fun getLayoutId(): Int {
        return R.layout.activity_chinese
    }

    override fun initData() {
        super.initData()
        initRv()
    }

    override fun initListener() {
        super.initListener()
        chinese_toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    fun initRv(){
        chinese_inner.layoutManager = LinearLayoutManager(this)
        chinese_inner.adapter = SubjectItemAdapter(list)

        chinese_outer.layoutManager = LinearLayoutManager(this)
        chinese_outer.adapter = SubjectItemAdapter(list)

        chinese_final.layoutManager = LinearLayoutManager(this)
        chinese_final.adapter = SubjectItemAdapter(list)

        chinese_exam.layoutManager = LinearLayoutManager(this)
        chinese_exam.adapter = SubjectItemAdapter(list)
    }

}
