package com.example.comeoneinstein.ui.activity

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.comeoneinstein.MyApplication
import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseActivity
import com.example.comeoneinstein.bean.CommendMethodItemBean
import com.example.comeoneinstein.bean.CommendVideoItemBean
import com.example.comeoneinstein.bean.DataBean
import com.example.comeoneinstein.bean.ItemBean
import com.example.comeoneinstein.model.DataModel
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_method.*
import org.jetbrains.anko.image

class MethodItemActivity : BaseActivity() {
    private var list : ArrayList<DataModel.MethodContentBanner> = arrayListOf(
        DataModel.MethodContentBanner("http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311"
        ,"无",1
        ),
        DataModel.MethodContentBanner("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fn.sinaimg.cn%2Ffront%2F400%2Fw700h500%2F20190131%2FTMtN-hshmsti5604365.jpg&refer=http%3A%2F%2Fn.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633328661&t=8be916e43d87d3372c3a3e9e06ce455d"
            ,"无",1
        ),
        DataModel.MethodContentBanner("http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311"
            ,"无",1
        ),
        DataModel.MethodContentBanner("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fn.sinaimg.cn%2Ffront%2F400%2Fw700h500%2F20190131%2FTMtN-hshmsti5604365.jpg&refer=http%3A%2F%2Fn.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633328661&t=8be916e43d87d3372c3a3e9e06ce455d"
            ,"无",1
        ),
        DataModel.MethodContentBanner("http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311"
            ,"无",1
        )

    )
    override fun getLayoutId(): Int {
        return R.layout.activity_method
    }

    override fun initData() {
        super.initData()
        initBanner()
        val item  = intent.getSerializableExtra("item") as ItemBean
        method_item_toolbar.title = item.title
        //图片加载
//        Glide.with(MyApplication.context).load(item.imageURL)
//            .placeholder(R.mipmap.item_method_black).into(method_item_content)


    }


    override fun initListener() {
        method_item_toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun initBanner(){
        var banner: Banner<DataModel.MethodContentBanner, BannerImageAdapter<DataModel.MethodContentBanner>> = findViewById(R.id.method_item_content)
        banner.setAdapter(object : BannerImageAdapter<DataModel.MethodContentBanner>(list) {
            override fun onBindView(holder: BannerImageHolder, data: DataModel.MethodContentBanner, position: Int, size: Int) {
                //图片加载自己实现
                Glide.with(holder.itemView)
                    .load(data.imageUrl)
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
                    .into(holder.imageView) }


        }).addBannerLifecycleObserver(this).setIndicator(CircleIndicator(this))
    }
}