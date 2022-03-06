package com.fadlurahmanf.starter_app_mvp

import android.app.Application
import android.content.Context
import androidx.work.*
import com.fadlurahmanf.starter_app_mvp.core.services.ExampleRxWorker2
import com.fadlurahmanf.starter_app_mvp.core.utils.AppWorkerFactory
import com.fadlurahmanf.starter_app_mvp.di.component.DaggerApplicationComponent
import javax.inject.Inject


class BaseApp : Application(), Configuration.Provider {
    val appComponent = DaggerApplicationComponent.factory().create(this)

    @Inject
    lateinit var workerFactory: AppWorkerFactory

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}