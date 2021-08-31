package com.example.comeoneinstein.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.comeoneinstein.MyApplication
import com.example.comeoneinstein.R
import com.example.comeoneinstein.ui.activity.ChineseActivity
import kotlinx.android.synthetic.main.fragment_videocommend.*
import org.jetbrains.anko.imageResource

class VideoCommendFragment : Fragment() {
    private val imageList = arrayOf(
        R.mipmap.carousel_bg,
        R.mipmap.carousel_bg,
        R.mipmap.carousel_bg,
        R.mipmap.carousel_bg,
        R.mipmap.carousel_bg
    )
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
        carouselListener()
        videoCommend_carouselView.pageCount = imageList.size



    }

    private fun carouselListener(){
        videoCommend_carouselView.setImageListener { position, imageView ->
            imageView.imageResource = imageList[position]
        }
    }

    private fun subjectListener(){
        chinese.setOnClickListener {
            val intent = Intent(MyApplication.context, ChineseActivity::class.java)
            startActivity(intent)

        }
    }

}
