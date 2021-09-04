package com.example.comeoneinstein.ui.activity

import android.app.AlertDialog
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comeoneinstein.MyApplication
import com.example.comeoneinstein.R
import com.example.comeoneinstein.adapter.MethodAdapter
import com.example.comeoneinstein.adapter.VideoAdapter
import com.example.comeoneinstein.base.BaseActivity
import com.example.comeoneinstein.bean.ItemBean
import com.example.comeoneinstein.util.UiRefreshUtil
import kotlinx.android.synthetic.main.activity_methodlist.*

class MethodListActivity : BaseActivity() {
    private var list : ArrayList<ItemBean> = arrayListOf(
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0"),
        ItemBean("名称","发布时间","次数","https://pic.baike.soso.com/ugc/baikepic2/5410/ori-20210330181534-1864981271_jpg_1215_717_139880.jpg/0")
    )

    override fun getLayoutId(): Int {
        return R.layout.activity_methodlist
    }

    override fun initData() {
        super.initData()

        initRv()
        navigationListener()

        methodList_title.text = intent.getStringExtra("list_title")

    }


    private fun initRv(){

        methodList_rv.layoutManager = LinearLayoutManager(MyApplication.context)
        val methodListAdapter = MethodAdapter(list)

        methodListAdapter.setOnItemClickListener(object : MethodAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(MyApplication.context, MethodItemActivity::class.java)
                startActivity(intent)
            }
        })

        methodListAdapter.setOnItemLongClickListener(object : MethodAdapter.OnItemLongClickListener{
            override fun onItemLongClick(view: View?, position: Int) {
                Log.e("sss","长按")
                AlertDialog.Builder(this@MethodListActivity).apply {
                    setTitle("温馨提示 ：")
                    setMessage("您确定要删除吗")
                    setCancelable(true)
                    setPositiveButton("确定"){ dialog,which ->
                        list.remove(list[position])
                        Toast.makeText(MyApplication.context,"删除了第$position 项", Toast.LENGTH_SHORT).show()
                        methodListAdapter.notifyDataSetChanged()
                    }
                    setNegativeButton("取消",null)
                    show()
                }

            }

        })
        methodList_rv.adapter = methodListAdapter

        //下拉刷新
        UiRefreshUtil.refreshItem(this,methodListAdapter,methodList_refresh)

    }

    private fun navigationListener(){
        methodList_toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}