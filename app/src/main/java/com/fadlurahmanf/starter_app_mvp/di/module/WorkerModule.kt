package com.fadlurahmanf.starter_app_mvp.di.module

import androidx.work.ListenableWorker
import com.fadlurahmanf.starter_app_mvp.core.services.ExampleRxWorker2
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
    @WorkerKey(ExampleRxWorker2::class)
    abstract fun bindExampleRxWorker(factory:ExampleRxWorker2.Factory) : ChildWorkerFactory
}