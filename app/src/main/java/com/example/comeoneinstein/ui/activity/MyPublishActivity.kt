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
import kotlinx.android.synthetic.main.fragment_records.*

class MyPublishActivity : BaseActivity(){
    private var list : ArrayList<ItemBean> = arrayListOf(
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0"),
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0"),
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0"),
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0"),
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0"),
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0"),
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0")
    )

    override fun getLayoutId(): Int {
        return R.layout.activity_mypublish
    }

    override fun initData() {
        initRecyclerView()

        myPublish_video_title.setOnClickListener {
            val intent = Intent(MyApplication.context, VideoListActivity::class.java)
            intent.putExtra("list_title",myPublish_video_title.text)
            startActivity(intent)
        }
        myPublish_method_title.setOnClickListener {
            val intent = Intent(MyApplication.context, MethodListActivity::class.java)
            intent.putExtra("list_title",myPublish_method_title.text)
            startActivity(intent)
        }
        myPublish_markdown_title.setOnClickListener {
            val intent = Intent(MyApplication.context, MarkdownListActivity::class.java)
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
                val intent = Intent(MyApplication.context, VideoItemActivity::class.java)
                intent.putExtra("item",list[position])
                startActivity(intent)
            }
        })
        myPublish_rv_video.adapter = videoAdapter

        myPublish_rv_method.layoutManager = LinearLayoutManager(this)
        val methodAdapter : MethodAdapter = MethodAdapter(list)
        methodAdapter.setOnItemClickListener(object : MethodAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(MyApplication.context, MethodItemActivity::class.java)
                intent.putExtra("item",list[position])
                startActivity(intent)
            }
        })
        myPublish_rv_method.adapter = methodAdapter

        myPublish_rv_markdown.layoutManager = LinearLayoutManager(this)
        val markdownAdapter = MarkdownAdapter(list)
        markdownAdapter.setOnItemClickListener(object : MarkdownAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(MyApplication.context, MethodItemActivity::class.java)
                intent.putExtra("item",list[position])
                startActivity(intent)
            }
        })
        myPublish_rv_markdown.adapter = markdownAdapter

    }
}