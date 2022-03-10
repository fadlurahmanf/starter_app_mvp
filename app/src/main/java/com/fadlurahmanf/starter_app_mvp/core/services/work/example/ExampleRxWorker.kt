package com.fadlurahmanf.starter_app_mvp.core.services.work.example

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import androidx.work.rxjava3.RxWorker
import androidx.work.workDataOf
import com.fadlurahmanf.starter_app_mvp.core.utils.ChildWorkerFactory
import com.fadlurahmanf.starter_app_mvp.core.utils.ExampleApiWorkService
import com.fadlurahmanf.starter_app_mvp.core.utils.WorkRetrofitServices
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ExampleRxWorker(
    context: Context,
    workerParameters: WorkerParameters
) : RxWorker(context, workerParameters) {
    private var services = WorkRetrofitServices.services(context).create(ExampleApiWorkService::class.java)
    override fun createWork(): Single<Result> {
        return Single.fromObservable(services.getTestimonialObservable())
            .map {
                Result.success(workDataOf("RESULT" to "SUCCESS"))
            }.onErrorReturn(){
                Result.failure(workDataOf("RESULT" to "FAILURE"))
            }
    }

    class Factory @Inject constructor(

    ) : ChildWorkerFactory {
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return ExampleRxWorker(context, workerParameters)
        }

    }
}