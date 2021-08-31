package com.example.comeoneinstein.ui.activity

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comeoneinstein.MyApplication
import com.example.comeoneinstein.R
import com.example.comeoneinstein.adapter.MarkdownAdapter
import com.example.comeoneinstein.adapter.MethodAdapter
import com.example.comeoneinstein.adapter.VideoAdapter
import com.example.comeoneinstein.base.BaseActivity
import com.example.comeoneinstein.bean.ItemBean
import kotlinx.android.synthetic.main.activity_myfavortie.*
import kotlinx.android.synthetic.main.activity_myfavortie.myFavorite_markdown_title
import kotlinx.android.synthetic.main.activity_myfavortie.myFavorite_method_title
import kotlinx.android.synthetic.main.activity_myfavortie.myFavorite_rv_markdown
import kotlinx.android.synthetic.main.activity_myfavortie.myFavorite_rv_method
import kotlinx.android.synthetic.main.activity_myfavortie.myFavorite_rv_video
import kotlinx.android.synthetic.main.activity_myfavortie.myFavorite_video_title
import kotlinx.android.synthetic.main.fragment_myfavorite.*

class MyFavoriteActivity : BaseActivity() {
    private val list = listOf(
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0")
    )

    override fun getLayoutId(): Int {
        return R.layout.activity_myfavortie
    }

    override fun initData() {
        super.initData()
        initRecyclerView()
    }

    override fun initListener() {
        super.initListener()

        initItemIntentListener()
    }


    private fun initItemIntentListener(){
        myFavorite_method_title.setOnClickListener {
            val intent = Intent(MyApplication.context, RankListActivity::class.java)
            intent.putExtra("list_title",myFavorite_method_title.text)
            startActivity(intent)
        }
        myFavorite_markdown_title.setOnClickListener {
            val intent = Intent(MyApplication.context, RankListActivity::class.java)
            intent.putExtra("list_title",myFavorite_markdown_title.text)
            startActivity(intent)
        }
        myFavorite_video_title.setOnClickListener {
            val intent = Intent(MyApplication.context, RankListActivity::class.java)
            intent.putExtra("list_title",myFavorite_video_title.text)
            startActivity(intent)
        }
    }

    private fun initRecyclerView(){
        myFavorite_rv_video.layoutManager = LinearLayoutManager(MyApplication.context)
        val videoAdapter = VideoAdapter(list)
        videoAdapter.setOnItemClickListener(object : VideoAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(MyApplication.context, VideoItemActivity::class.java)
                startActivity(intent)
            }
        })
        myFavorite_rv_video.adapter = videoAdapter

        myFavorite_rv_method.layoutManager = LinearLayoutManager(MyApplication.context)
        val methodAdapter = MethodAdapter(list)
        methodAdapter.setOnItemClickListener(object : MethodAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(MyApplication.context, MethodItemActivity::class.java)
                startActivity(intent)
            }
        })
        myFavorite_rv_method.adapter = methodAdapter

        myFavorite_rv_markdown.layoutManager = LinearLayoutManager(MyApplication.context)
        val markdownAdapter = MarkdownAdapter(list)
        markdownAdapter.setOnItemClickListener(object : MarkdownAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(MyApplication.context, MethodItemActivity::class.java)
                startActivity(intent)
            }
        })
        myFavorite_rv_markdown.adapter = markdownAdapter
    }
}