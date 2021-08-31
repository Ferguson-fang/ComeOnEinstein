package com.example.comeoneinstein.model

import android.app.Notification

class DataModel {
    data class VideoItem(val pictureUrl : String,val title : String
                         ,val releaseTime : String,val learnedTimes : String)
    data class MethodItem(val pictureUrl : String,val title : String
                          ,val releaseTime : String,val learnedTimes : String)
    data class MarkdownItem(val pictureUrl : String,val title : String
                          ,val releaseTime : String,val learnedTimes : String)
}