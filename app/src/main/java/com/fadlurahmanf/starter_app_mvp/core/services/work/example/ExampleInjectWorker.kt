package com.fadlurahmanf.starter_app_mvp.core.services.work.example

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.fadlurahmanf.starter_app_mvp.core.utils.ChildWorkerFactory
import com.fadlurahmanf.starter_app_mvp.data.entity.example.TestimonialEntity
import javax.inject.Inject

class ExampleInjectWorker (
    context: Context,
    workerParameters: WorkerParameters,
    var testimonialEntity: TestimonialEntity
) : Worker(context, workerParameters){
    class Factory @Inject constructor(
        var testimonialEntity: TestimonialEntity
    ) : ChildWorkerFactory{
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return ExampleInjectWorker(context, workerParameters, testimonialEntity)
        }

    }

    override fun doWork(): Result {
        println("MASUK ${testimonialEntity} IN EXAMPLE INJECT WORKER CLASS")
        return Result.success(workDataOf("RESULT" to "SUCCESS"))
    }
}