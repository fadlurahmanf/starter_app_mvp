package com.fadlurahmanf.starter_app_mvp.core.services

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import okhttp3.OkHttpClient
import javax.inject.Inject

class ExampleWorkManager @Inject constructor(
    var context: Context,
    workerParams:WorkerParameters
) : Worker(context, workerParams){
    override fun doWork(): Result {
        return Result.success()
    }
}