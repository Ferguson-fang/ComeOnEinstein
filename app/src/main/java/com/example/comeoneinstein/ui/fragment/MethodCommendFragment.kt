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
import com.example.comeoneinstein.adapter.CommendMethodAdapter
import com.example.comeoneinstein.bean.CommendMethodItemBean
import com.example.comeoneinstein.ui.activity.MethodItemActivity
import com.example.comeoneinstein.ui.activity.RankListActivity
import kotlinx.android.synthetic.main.fragment_methodcommend.*

class MethodCommendFragment : Fragment() {
    private val list = listOf(
        CommendMethodItemBean("方法名称","xxx","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        CommendMethodItemBean("方法名称","xxx","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        CommendMethodItemBean("方法名称","xxx","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        CommendMethodItemBean("方法名称","xxx","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        CommendMethodItemBean("方法名称","xxx","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        CommendMethodItemBean("方法名称","xxx","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_methodcommend, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRv()

        solve_popular_title.setOnClickListener {
            val intent = Intent(MyApplication.context,RankListActivity::class.java)
            intent.putExtra("list_title",solve_popular_title.text)
            startActivity(intent)
        }
        efficiency_popular_title.setOnClickListener {
            val intent = Intent(MyApplication.context,RankListActivity::class.java)
            intent.putExtra("list_title",efficiency_popular_title.text)
            startActivity(intent)
        }
    }

    private fun initRv(){
        solve_popular_rv.layoutManager = LinearLayoutManager(MyApplication.context,LinearLayoutManager.HORIZONTAL,false)
        val solveMethodAdapter : CommendMethodAdapter = CommendMethodAdapter(list)
        solveMethodAdapter.setOnItemClickListener(object : CommendMethodAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(MyApplication.context, MethodItemActivity::class.java)
                startActivity(intent)
            }
        })
        solve_popular_rv.adapter = solveMethodAdapter

        efficiency_popular_rv.layoutManager = LinearLayoutManager(MyApplication.context,LinearLayoutManager.HORIZONTAL,false)
        val efficiencyMethodAdapter = CommendMethodAdapter(list)
        efficiencyMethodAdapter.setOnItemClickListener(object : CommendMethodAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(MyApplication.context, MethodItemActivity::class.java)
                startActivity(intent)
            }
        })
        efficiency_popular_rv.adapter = efficiencyMethodAdapter
    }

    /**
     * myPublish_rv_video.layoutManager = LinearLayoutManager(this)
    val videoAdapter : VideoAdapter = VideoAdapter(list)
    videoAdapter.setOnItemClickListener(object : VideoAdapter.OnItemClickListener{
    override fun onItemClick(view: View?, position: Int) {
    startNextActivity<VideoItemActivity>()
    }
    })
    myPublish_rv_video.adapter = videoAdapter
     * */


}
