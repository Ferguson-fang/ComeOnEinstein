package com.example.comeoneinstein.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.comeoneinstein.MyApplication
import com.example.comeoneinstein.R
import com.example.comeoneinstein.bean.DataBean
import com.example.comeoneinstein.ui.activity.ChineseActivity
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.fragment_videocommend.*
import org.jetbrains.anko.imageResource

class VideoCommendFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_videocommend, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initCarousel()

        subjectListener()
    }

    private fun initCarousel(){

        //设置轮播图的页面数量
        //carouselListener()
        //videoCommend_carouselView.pageCount = imageList.size
        var banner: Banner<DataBean, BannerImageAdapter<DataBean>> = view!!.findViewById(R.id.banner)
        banner.setAdapter(object : BannerImageAdapter<DataBean>(DataBean.testData3) {
            override fun onBindView(holder: BannerImageHolder, data: DataBean, position: Int, size: Int) {
                //图片加载自己实现
                Glide.with(holder.itemView)
                    .load(data.imageUrl)
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
                    .into(holder.imageView) }
        }).addBannerLifecycleObserver(this).setIndicator(CircleIndicator(activity))



    }

//    private fun carouselListener(){
//        videoCommend_carouselView.setImageListener { position, imageView ->
//            imageView.imageResource = imageList[position]
//        }
//    }

    private fun subjectListener(){
        chinese.setOnClickListener {
            val intent = Intent(MyApplication.context, ChineseActivity::class.java)
            startActivity(intent)

        }
    }

}
