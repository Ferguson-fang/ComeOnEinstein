package com.example.comeoneinstein.ui.activity

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comeoneinstein.MyApplication
import com.example.comeoneinstein.R
import com.example.comeoneinstein.adapter.MarkdownAdapter
import com.example.comeoneinstein.adapter.MethodAdapter
import com.example.comeoneinstein.adapter.VideoAdapter
import com.example.comeoneinstein.base.BaseActivity
import com.example.comeoneinstein.bean.ItemBean
import kotlinx.android.synthetic.main.activity_mypublish.*
import kotlinx.android.synthetic.main.fragment_markdowncommend.*

class MyPublishActivity : BaseActivity(){
    private val list = listOf(
            ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0")
    )
    override fun getLayoutId(): Int {
        return R.layout.activity_mypublish
    }

    override fun initData() {
        initRecyclerView()

        myPublish_video_title.setOnClickListener {
            val intent = Intent(MyApplication.context, RankListActivity::class.java)
            intent.putExtra("list_title",myPublish_video_title.text)
            startActivity(intent)
        }
        myPublish_method_title.setOnClickListener {
            val intent = Intent(MyApplication.context, RankListActivity::class.java)
            intent.putExtra("list_title",myPublish_method_title.text)
            startActivity(intent)
        }
        myPublish_markdown_title.setOnClickListener {
            val intent = Intent(MyApplication.context, RankListActivity::class.java)
            intent.putExtra("list_title",myPublish_markdown_title.text)
            startActivity(intent)
        }

    }

    override fun initListener() {
        myPublish_toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun initRecyclerView(){
        myPublish_rv_video.layoutManager = LinearLayoutManager(this)
        val videoAdapter : VideoAdapter = VideoAdapter(list)
        videoAdapter.setOnItemClickListener(object : VideoAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                startNextActivity<VideoItemActivity>()
            }
        })
        myPublish_rv_video.adapter = videoAdapter

        myPublish_rv_method.layoutManager = LinearLayoutManager(this)
        val methodAdapter : MethodAdapter = MethodAdapter(list)
        methodAdapter.setOnItemClickListener(object : MethodAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                startNextActivity<MethodItemActivity>()
            }
        })
        myPublish_rv_method.adapter = methodAdapter

        myPublish_rv_markdown.layoutManager = LinearLayoutManager(this)
        myPublish_rv_markdown.adapter = MarkdownAdapter(list)

    }
}