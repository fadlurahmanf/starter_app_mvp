package com.fadlurahmanf.starter_app_mvp

import android.app.Application
import com.fadlurahmanf.starter_app_mvp.di.component.DaggerApplicationComponent


class BaseApp : Application() {
    val appComponent = DaggerApplicationComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}