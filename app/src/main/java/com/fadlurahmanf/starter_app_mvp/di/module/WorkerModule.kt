package com.fadlurahmanf.starter_app_mvp.di.module

import androidx.work.ListenableWorker
import com.fadlurahmanf.starter_app_mvp.core.services.work.example.ExampleCoroutineWorkManager
import com.fadlurahmanf.starter_app_mvp.core.services.work.example.ExampleInjectWorker
import com.fadlurahmanf.starter_app_mvp.core.services.work.example.ExampleRxWorker
import com.fadlurahmanf.starter_app_mvp.core.utils.ChildWorkerFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class WorkerKey(val value: KClass<out ListenableWorker>)

@Module
abstract class WorkerModule {
    @Binds
    @IntoMap
    @WorkerKey(ExampleRxWorker::class)
    abstract fun bindExampleRxWorker(factory:ExampleRxWorker.Factory) : ChildWorkerFactory

    @Binds
    @IntoMap
    @WorkerKey(ExampleCoroutineWorkManager::class)
    abstract fun bindExampleCoroutineWorker(factory:ExampleCoroutineWorkManager.Factory) : ChildWorkerFactory

    @Binds
    @IntoMap
    @WorkerKey(ExampleInjectWorker::class)
    abstract fun bindExampleInjectWorker(factory: ExampleInjectWorker.Factory) : ChildWorkerFactory
}