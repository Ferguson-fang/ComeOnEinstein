package com.example.comeoneinstein.model

import android.app.Notification
import androidx.room.Entity
import androidx.room.PrimaryKey

class DataModel {
    data class VideoItem(val pictureUrl : String,val title : String
                         ,val releaseTime : String,val learnedTimes : String)
    data class MethodItem(val pictureUrl : String,val title : String
                          ,val releaseTime : String,val learnedTimes : String)
    data class MarkdownItem(val pictureUrl : String,val title : String
                          ,val releaseTime : String,val learnedTimes : String)
    @Entity
    data class Count(var count : String,var password :String){
        @PrimaryKey(autoGenerate = true)//设置为主键，autoGenerate = true主键的值自动生成
        var id:Long = 0
    }
}