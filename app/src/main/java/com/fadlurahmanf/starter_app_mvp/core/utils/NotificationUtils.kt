package com.fadlurahmanf.starter_app_mvp.core.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.fadlurahmanf.starter_app_mvp.R
import com.fadlurahmanf.starter_app_mvp.data.model.core.NotificationData
import javax.inject.Inject

class NotificationUtils @Inject constructor(var context: Context) {

    companion object{
        const val CHANNEL_ID = "DEFAULT_CHANNEL_ID"
    }

    private var notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    private lateinit var notificationBuilder: NotificationCompat.Builder


    private fun buildNotification(data: NotificationData){
        notificationBuilder = NotificationCompat.Builder(context.applicationContext, data.channelId?:"DEFAULT_CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_discipleship)
            .setContentTitle(data.title)
            .setContentText(data.content)
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("Much longer text that cannot fit one line..."))
            .setContentIntent(data.pendingIntent)
            .setPriority(data.priority)
    }

    fun showNotification(data: NotificationData){
        buildNotification(data)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channelId = data.channelId
//            val channel = NotificationChannel(channelId,
//                "Channel human readable title",
//                NotificationManager.IMPORTANCE_HIGH,
//            )
//            notificationManager.createNotificationChannel(channel)
//            notificationBuilder.setChannelId(channelId)
        }
        notificationManager.notify(0, notificationBuilder.build())
    }

}