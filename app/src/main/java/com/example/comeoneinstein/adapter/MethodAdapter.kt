package com.example.comeoneinstein.adapter

import android.content.Intent
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

class MethodAdapter(private val list: List<ItemBean>) : RecyclerView.Adapter<MethodAdapter.ViewHolder>() {
    private var mOnItemClickListener: OnItemClickListener? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.item_method_name)
        val time : TextView = itemView.findViewById(R.id.item_method_time)
        val times : TextView = itemView.findViewById(R.id.item_method_times)
        val imageURL : ImageView = itemView.findViewById(R.id.item_method_iv)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MethodAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_method,parent,false)


        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MethodAdapter.ViewHolder, position: Int) {
        var items = list[position]
        holder.title.text = items.title
        holder.time.text = items.time
        holder.itemView.setOnClickListener {
            mOnItemClickListener?.onItemClick(it,position)
        }
        //图片加载
        Glide.with(MyApplication.context).load(items.imageURL).placeholder(R.mipmap.item_method_black).into(holder.imageURL)
    }

    //内部接口
    interface OnItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }


    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }

}