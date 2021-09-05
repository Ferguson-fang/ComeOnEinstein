package com.example.comeoneinstein.bean

import java.io.Serializable

/**
 * title -> 名称
 * time -> 发布时间
 * amount -> 收藏量
 * times -> 学习次数
 * imageURL -> 封面图片
 * */
data class ItemBean(val title : String,val time : String,val times : String,val imageURL : String,val amount : String) : Serializable