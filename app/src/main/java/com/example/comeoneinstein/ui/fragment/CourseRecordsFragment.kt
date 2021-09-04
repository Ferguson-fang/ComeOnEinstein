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
import com.example.comeoneinstein.adapter.VideoAdapter
import com.example.comeoneinstein.base.BaseFragment
import com.example.comeoneinstein.bean.ItemBean
import com.example.comeoneinstein.ui.activity.VideoItemActivity
import com.example.comeoneinstein.util.UiRefreshUtil
import kotlinx.android.synthetic.main.fragment_coursemyfavorite.*
import kotlinx.android.synthetic.main.fragment_coursemylike.*
import kotlinx.android.synthetic.main.fragment_courserecords.*
import org.jetbrains.anko.support.v4.runOnUiThread
import kotlin.concurrent.thread

class CourseRecordsFragment : Fragment(){
    private var list : ArrayList<ItemBean> = arrayListOf(
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_courserecords, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        courseRecords_rv.layoutManager = LinearLayoutManager(MyApplication.context)
        val recordsAdapter = VideoAdapter(list)
        recordsAdapter.setOnItemClickListener(object : VideoAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(MyApplication.context, VideoItemActivity::class.java)
                startActivity(intent)
            }
        })

        recordsAdapter.setOnItemLongClickListener(object : VideoAdapter.OnItemLongClickListener{
            override fun onItemLongClick(view: View?, position: Int) {

                AlertDialog.Builder(activity).apply {
                    setTitle("温馨提示 ：")
                    setMessage("您确定要删除吗")
                    setCancelable(true)
                    setPositiveButton("确定"){ dialog,which ->
                        list.remove(list[position])
                        Toast.makeText(MyApplication.context,"删除了第$position 项", Toast.LENGTH_SHORT).show()
                        recordsAdapter.notifyDataSetChanged()
                    }
                    setNegativeButton("取消",null)
                    show()
                }
            }
        })

        courseRecords_rv.adapter = recordsAdapter
        //下拉刷新
        UiRefreshUtil.refreshItem(this.activity,recordsAdapter,courseRecords_refresh)

    }

}
