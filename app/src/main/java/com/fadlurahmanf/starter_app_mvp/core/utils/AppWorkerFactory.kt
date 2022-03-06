package com.fadlurahmanf.starter_app_mvp.core.utils

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

interface ChildWorkerFactory{
    fun create(context: Context, workerParameters: WorkerParameters) : ListenableWorker
}

@Singleton
class AppWorkerFactory @Inject constructor(
    private var workerFactories:Map<Class<out ListenableWorker>, @JvmSuppressWildcards Provider<ChildWorkerFactory>>
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        val provider = workerFactories.entries.find { Class.forName(workerClassName).isAssignableFrom(it.key) }
        val providerValue = provider?.value?.get() ?: throw IllegalArgumentException("Unknown name class $workerClassName")
        return providerValue.create(appContext, workerParameters)
    }
}