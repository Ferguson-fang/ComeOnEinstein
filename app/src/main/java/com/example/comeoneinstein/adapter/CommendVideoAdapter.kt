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
import com.example.comeoneinstein.bean.CommendVideoItemBean


class CommendVideoAdapter(private val list: List<CommendVideoItemBean> ):
    RecyclerView.Adapter<CommendVideoAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title : TextView = itemView.findViewById(R.id.item_commend_video_name)
        val imageURL : ImageView = itemView.findViewById(R.id.item_commend_video_iv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_commend_video,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var items = list[position]
        holder.title.text = items.title
        //图片加载
        Glide.with(MyApplication.context).load(items.imageURL)
            .placeholder(R.mipmap.item_method_black).into(holder.imageURL)
    }
}