package com.example.comeoneinstein.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.comeoneinstein.MyApplication
import com.example.comeoneinstein.R
import com.example.comeoneinstein.bean.ItemBean
import kotlinx.android.synthetic.main.subject_item_video.view.*

class SubjectItemAdapter(private val list: List<ItemBean>) : RecyclerView.Adapter<SubjectItemAdapter.ViewHolder>(){

    private var mOnItemClickListener: SubjectItemAdapter.OnItemClickListener? = null


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.subject_item_video_name)
        val time : TextView = itemView.findViewById(R.id.subject_item_video_time)
        val times : TextView = itemView.findViewById(R.id.subject_item_video_times)
        val imageURL : ImageView = itemView.findViewById(R.id.subject_item_video_iv)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubjectItemAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.subject_item_video,parent,false)


        return ViewHolder(view)
    }

    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: SubjectItemAdapter.ViewHolder, position: Int) {
        var items = list[position]
        holder.title.text = items.title
        holder.time.text = items.time
        holder.itemView.setOnClickListener {
            mOnItemClickListener?.onItemClick(it,position)
        }
        //图片加载
        Glide.with(MyApplication.context).load(items.imageURL).placeholder(R.mipmap.item_video_black).into(holder.imageURL)
    }

    //内部接口
    interface OnItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }


    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }
}