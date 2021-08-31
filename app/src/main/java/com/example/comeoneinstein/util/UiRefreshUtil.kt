package com.example.comeoneinstein.util

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.comeoneinstein.R
import com.example.comeoneinstein.base.BaseActivity
import org.jetbrains.anko.support.v4.runOnUiThread
import kotlin.concurrent.thread

object UiRefreshUtil {
    /**
     * 下拉刷新
     *
     * @param offset 数据偏移量
     * @param size   返回数据的条目个数
     * @return url
     */
    fun <T>refreshItem(activity: FragmentActivity?,adapter: T,refreshId : SwipeRefreshLayout){
        refreshId.setColorSchemeResources(R.color.vpi__bright_foreground_holo_light)
        refreshId.setOnRefreshListener {
            thread {
                activity?.runOnUiThread {
                    Thread.sleep(2000)
                    refreshId.isRefreshing = false
                }
            }
        }
    }

    fun <T>refreshItem(activity: BaseActivity,adapter: T,refreshId : SwipeRefreshLayout){
        refreshId.setColorSchemeResources(R.color.vpi__bright_foreground_holo_light)
        refreshId.setOnRefreshListener {
            thread {
                activity?.runOnUiThread {
                    Thread.sleep(2000)
                    refreshId.isRefreshing = false
                }
            }
        }
    }

}