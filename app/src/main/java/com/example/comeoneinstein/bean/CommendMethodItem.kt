package com.example.comeoneinstein.bean

import java.io.Serializable

/**
 * title -> 名称
 * amount -> 收藏量
 * imageURL -> 封面图片
 * */
data class CommendMethodItemBean (val title : String,val amount : String,val imageURL : String) : Serializable