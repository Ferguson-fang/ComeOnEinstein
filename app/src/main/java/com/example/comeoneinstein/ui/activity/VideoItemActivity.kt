package com.example.comeoneinstein.ui.activity

import android.net.Uri
import androidx.recyclerview.widget.LinearLayoutManager
import cn.jzvd.Jzvd
import com.example.comeoneinstein.MyApplication
import com.example.comeoneinstein.R
import com.example.comeoneinstein.adapter.CommendVideoAdapter
import com.example.comeoneinstein.base.BaseActivity
import com.example.comeoneinstein.bean.CommendVideoItemBean
import com.example.comeoneinstein.bean.ItemBean
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
        initVideo()


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

    private fun initVideo(){
        val item = intent.getSerializableExtra("item") as ItemBean
        video_item_content.setUp("https://photovideo.photo.qq.com/1074_0b537xcaymia5eaenojuqbqtf7iebssaad2a.f0.mp4?dis_k=9b1271d7481c2c8d41a1936b6aab55c4&dis_t=1630816801&vuin=834929497"
            , item.title)
        video_item_content.posterImageView.setImageURI(Uri.parse("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640"))

    }

    override fun onBackPressed() {
        if (Jzvd.backPress()) {
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        Jzvd.releaseAllVideos()
    }

}
