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
import com.example.comeoneinstein.bean.CommendMethodItemBean

class CommendMethodAdapter(private val list: List<CommendMethodItemBean>) : RecyclerView.Adapter<CommendMethodAdapter.ViewHolder>(){
    private var mOnItemClickListener: OnItemClickListener? = null
    private var monItemLongClickListener : OnItemLongClickListener? =null
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.item_commend_method_name)
        val amount : TextView = itemView.findViewById(R.id.item_commend_method_amount)
        val imageURL : ImageView = itemView.findViewById(R.id.item_commend_method_iv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommendMethodAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_commend_method,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CommendMethodAdapter.ViewHolder, position: Int) {
        var items = list[position]
        holder.title.text = items.title
        holder.amount.text = items.amount
        holder.itemView.setOnClickListener {
            mOnItemClickListener?.onItemClick(it,position)
        }
        //图片加载
        Glide.with(MyApplication.context).load(items.imageURL)
            .placeholder(R.mipmap.item_method_black).into(holder.imageURL)
    }

    //内部接口
    interface OnItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }


    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }

    //内部接口
    interface OnItemLongClickListener {
        fun onItemLongClick(view: View?, position: Int)
    }


    fun setOnItemLongClickListener(onItemLongClickListener: OnItemLongClickListener) {
        monItemLongClickListener = onItemLongClickListener
    }

}