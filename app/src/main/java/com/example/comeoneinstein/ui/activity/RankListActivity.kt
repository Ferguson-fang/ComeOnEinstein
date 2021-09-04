package com.example.comeoneinstein.ui.activity

import android.app.AlertDialog
import android.app.ProgressDialog.show
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comeoneinstein.MyApplication
import com.example.comeoneinstein.R
import com.example.comeoneinstein.adapter.CommendMethodAdapter
import com.example.comeoneinstein.adapter.VideoAdapter
import com.example.comeoneinstein.base.BaseActivity
import com.example.comeoneinstein.bean.ItemBean
import com.example.comeoneinstein.util.UiRefreshUtil
import kotlinx.android.synthetic.main.activity_ranklist.*

/**
 * 所有排行榜的公用activity
 * 根据选中的排行榜不同传入不同的初始化数据
 * 启动不同的排行榜
 * */
class RankListActivity : BaseActivity() {
    private var list : ArrayList<ItemBean> = arrayListOf(
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0")
    )
    override fun getLayoutId(): Int {
        return R.layout.activity_ranklist

    }

    override fun initData() {
        super.initData()

        initRv()
        navigationListener()

        rankList_title.text = intent.getStringExtra("list_title")

    }


    private fun initRv(){

        rankList_rv.layoutManager = LinearLayoutManager(MyApplication.context)
        val rankListAdapter = VideoAdapter(list)

        rankListAdapter.setOnItemClickListener(object : VideoAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(MyApplication.context, VideoItemActivity::class.java)
                startActivity(intent)
            }
        })

        rankList_rv.adapter = rankListAdapter

        //下拉刷新
        UiRefreshUtil.refreshItem(this,rankListAdapter,rankList_refresh)

    }

    private fun navigationListener(){
        rankList_toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}