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

class MyFavoriteActivity : BaseActivity() {
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
        return R.layout.activity_myfavortie
    }

    override fun initData() {
        super.initData()
        initRecyclerView()
    }

    override fun initListener() {
        super.initListener()

        initItemIntentListener()
        myFavorite_toolbar.setNavigationOnClickListener {
            finish()
        }
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
                intent.putExtra("item",list[position])
                startActivity(intent)
            }
        })
        myFavorite_rv_video.adapter = videoAdapter

        myFavorite_rv_method.layoutManager = LinearLayoutManager(MyApplication.context)
        val methodAdapter = MethodAdapter(list)
        methodAdapter.setOnItemClickListener(object : MethodAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(MyApplication.context, MethodItemActivity::class.java)
                intent.putExtra("item",list[position])
                startActivity(intent)
            }
        })
        myFavorite_rv_method.adapter = methodAdapter

        myFavorite_rv_markdown.layoutManager = LinearLayoutManager(MyApplication.context)
        val markdownAdapter = MarkdownAdapter(list)
        markdownAdapter.setOnItemClickListener(object : MarkdownAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(MyApplication.context, MethodItemActivity::class.java)
                intent.putExtra("item",list[position])
                startActivity(intent)
            }
        })
        myFavorite_rv_markdown.adapter = markdownAdapter
    }
}