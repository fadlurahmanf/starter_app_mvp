package com.fadlurahmanf.starter_app_mvp.core.services

//import android.content.Context
//import androidx.work.*
//import androidx.work.rxjava3.RxWorker
//import com.fadlurahmanf.starter_app_mvp.core.utils.ChildWorkerFactory
//import com.fadlurahmanf.starter_app_mvp.data.repository.example.ExampleRepository
//import com.fadlurahmanf.starter_app_mvp.data.response.example.BaseResponse
//import com.google.gson.Gson
//import io.reactivex.rxjava3.core.Single
//import kotlinx.coroutines.*
//import javax.inject.Inject
//
//
//class ExampleWorkManager (
//    context: Context,
//    workerParams: WorkerParameters
//) : CoroutineWorker(context, workerParams){
//
//    private var services:TestimonialApiService = RetrofitService.services(context).create(TestimonialApiService::class.java)
//
//    override suspend fun doWork(): Result {
//        withContext(Dispatchers.IO) {
//            var result = services.getTestimonial()
//            println("MASUK HASIL ${result.message}")
//            return@withContext Result.success()
//        }
//        return Result.failure()
//    }
//}
//
//class ExampleRxWorker(
//    context: Context,
//    workerParams: WorkerParameters
//) : RxWorker(context, workerParams){
//
//    private var services:TestimonialApiService = RetrofitService.services(context).create(TestimonialApiService::class.java)
//
//    override fun createWork(): Single<Result> {
//        return Single.fromObservable(services.getTestimonialObservable().map {
//            if (it.code == 100){
//                Result.success(workDataOf("MESSAGE" to Gson().toJson(it)))
//            }else{
//                Result.failure(workDataOf("MESSAGE" to Gson().toJson(BaseResponse(code = it.code, message = it.message, data = null))))
//            }
//        }.onErrorReturn {
//            Result.failure(workDataOf("MESSAGE" to Gson().toJson(BaseResponse(code = null, message = it.message, data = null))))
//        })
//    }
//
//}
//
//class ExampleRxWorker2(
//    context: Context,
//    workerParams: WorkerParameters,
//    var repository: ExampleRepository
//):RxWorker(context, workerParams){
//    override fun createWork(): Single<Result> {
//        println("MASUK ${repository.text1}")
//        return Single.error(Throwable("e"))
//    }
//
//    class Factory @Inject constructor(
//        private val myRepository: ExampleRepository,
//    ): ChildWorkerFactory {
//        override fun create(appContext: Context, params: WorkerParameters): ExampleRxWorker2 {
//            return ExampleRxWorker2(appContext, params, myRepository)
//        }
//    }
//}