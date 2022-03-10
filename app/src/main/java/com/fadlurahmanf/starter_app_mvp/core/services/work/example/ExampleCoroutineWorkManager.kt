package com.fadlurahmanf.starter_app_mvp.core.services.work.example

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.fadlurahmanf.starter_app_mvp.core.utils.ChildWorkerFactory
import com.fadlurahmanf.starter_app_mvp.core.utils.ExampleApiWorkService
import com.fadlurahmanf.starter_app_mvp.core.utils.WorkRetrofitServices
import java.lang.Exception
import javax.inject.Inject

class ExampleCoroutineWorkManager(
    context: Context,
    workerParameters: WorkerParameters
):CoroutineWorker(context, workerParameters) {
    private var services: ExampleApiWorkService = WorkRetrofitServices.services(context).create(ExampleApiWorkService::class.java)
    override suspend fun doWork(): Result {
        try {
            var result = services.getTestimonialCoroutine().execute()
            return Result.success(workDataOf("RESULT" to "SUCCESS"))
        }catch (e:Exception){
            // todo exception here
            return Result.failure(workDataOf("RESULT" to "FAILURE"))
        }
    }

    class Factory @Inject constructor(

    ) : ChildWorkerFactory{
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return ExampleCoroutineWorkManager(context, workerParameters)
        }
    }
}