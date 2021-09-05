package com.example.comeoneinstein.ui.fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comeoneinstein.MyApplication
import com.example.comeoneinstein.R
import com.example.comeoneinstein.adapter.CommendMethodAdapter
import com.example.comeoneinstein.adapter.VideoAdapter
import com.example.comeoneinstein.base.BaseFragment
import com.example.comeoneinstein.bean.ItemBean
import com.example.comeoneinstein.ui.activity.MethodItemActivity
import com.example.comeoneinstein.ui.activity.VideoItemActivity
import com.example.comeoneinstein.util.UiRefreshUtil
import kotlinx.android.synthetic.main.fragment_coursemylike.*
import org.jetbrains.anko.support.v4.defaultSharedPreferences
import org.jetbrains.anko.support.v4.runOnUiThread
import kotlin.concurrent.thread

class CourseMyLikeFragment : Fragment(){
    private var list : ArrayList<ItemBean> = arrayListOf(
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0"),
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0"),
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0"),
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0"),
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0"),
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0"),
        ItemBean("名称","发布时间","次数","http://a1.qpic.cn/psc?/835d6022-3dfa-4310-92a2-fb003070baac/05RlWl8gsTOH*Z17MtCBzLCygYp1gnxDtpY31ueclZ.g3h*6QM58MUnfiHP2DqViH4jEgELJ85.ySmKScs6E*w!!/b&ek=1&kp=1&pt=0&bo=OASgBTgEoAURADc!&tl=1&tm=1630738800&sce=0-12-12&rf=viewer_311","0")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coursemylike, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        courseMyLike_rv.layoutManager = LinearLayoutManager(MyApplication.context)
        val myLikeAdapter = VideoAdapter(list)
        myLikeAdapter.setOnItemClickListener(object : VideoAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(MyApplication.context, VideoItemActivity::class.java)
                intent.putExtra("item",list[position])
                startActivity(intent)
            }
        })
        myLikeAdapter.setOnItemLongClickListener(object : VideoAdapter.OnItemLongClickListener{
            override fun onItemLongClick(view: View?, position: Int) {
                AlertDialog.Builder(activity).apply {
                    setTitle("温馨提示 ：")
                    setMessage("您确定要删除吗")
                    setCancelable(true)
                    setPositiveButton("确定"){ dialog,which ->
                        list.remove(list[position])
                        Toast.makeText(MyApplication.context,"删除了第$position 项", Toast.LENGTH_SHORT).show()
                        myLikeAdapter.notifyDataSetChanged()
                    }
                    setNegativeButton("取消",null)
                    show()
                }
            }
        })
        courseMyLike_rv.adapter = myLikeAdapter
        //下拉刷新
        UiRefreshUtil.refreshItem(this.activity,myLikeAdapter,courseMyLike_refresh)

    }

}
