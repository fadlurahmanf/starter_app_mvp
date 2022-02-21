package com.fadlurahmanf.starter_app_mvp.data.model.core

import android.app.PendingIntent
import androidx.core.app.NotificationCompat

data class NotificationData(
    var channelId:String,
    var notificationId:Int?=null,
    var pendingIntent: PendingIntent?=null,
    var content:String = "DEFAULT CONTENT TEXT",
    var title:String = "DEFAULT CONTENT TITLE",
    var priority:Int = NotificationCompat.PRIORITY_MAX,
)