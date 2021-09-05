package com.example.comeoneinstein.ui.activity

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comeoneinstein.R
import com.example.comeoneinstein.adapter.SubjectItemAdapter
import com.example.comeoneinstein.adapter.VideoAdapter
import com.example.comeoneinstein.base.BaseActivity
import com.example.comeoneinstein.bean.CommendMethodItemBean
import com.example.comeoneinstein.bean.ItemBean
import kotlinx.android.synthetic.main.activity_chinese.*

class ChineseActivity : BaseActivity(){
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
        return R.layout.activity_chinese
    }

    override fun initData() {
        super.initData()
        initRv()
    }

    override fun initListener() {
        super.initListener()
        chinese_toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    fun initRv(){
        chinese_inner.layoutManager = LinearLayoutManager(this)
        chinese_inner.adapter = SubjectItemAdapter(list)

        chinese_outer.layoutManager = LinearLayoutManager(this)
        chinese_outer.adapter = SubjectItemAdapter(list)

        chinese_final.layoutManager = LinearLayoutManager(this)
        chinese_final.adapter = SubjectItemAdapter(list)

        chinese_exam.layoutManager = LinearLayoutManager(this)
        chinese_exam.adapter = SubjectItemAdapter(list)
    }

}
