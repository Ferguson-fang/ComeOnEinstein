package com.example.comeoneinstein.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comeoneinstein.MyApplication
import com.example.comeoneinstein.R
import com.example.comeoneinstein.adapter.MarkdownAdapter
import com.example.comeoneinstein.adapter.MethodAdapter
import com.example.comeoneinstein.adapter.VideoAdapter
import com.example.comeoneinstein.bean.ItemBean
import com.example.comeoneinstein.ui.activity.*
import kotlinx.android.synthetic.main.fragment_markdowncommend.*
import kotlinx.android.synthetic.main.fragment_myfavorite.*

class MyFavoriteFragment : Fragment() {
    private val list = listOf(
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pica.zhimg.com/v2-7a38981ba24d9ca4b480f1a0e4686233.jpg?source=8673f162")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_myfavorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()

        myFavorite_method_title.setOnClickListener {
            val intent = Intent(MyApplication.context, MethodListActivity::class.java)
            intent.putExtra("list_title",myFavorite_method_title.text)
            startActivity(intent)
        }
        myFavorite_markdown_title.setOnClickListener {
            val intent = Intent(MyApplication.context, MarkdownListActivity::class.java)
            intent.putExtra("list_title",myFavorite_markdown_title.text)
            startActivity(intent)
        }
        myFavorite_video_title.setOnClickListener {
            val intent = Intent(MyApplication.context, VideoListActivity::class.java)
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
