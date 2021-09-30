package com.fadlurahmanf.starter_app_mvp

import android.app.Application
import com.fadlurahmanf.starter_app_mvp.di.ApplicationComponent
import com.fadlurahmanf.starter_app_mvp.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class BaseApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector:DispatchingAndroidInjector<Any>

    lateinit var applicationComponent: ApplicationComponent

    override fun androidInjector(): AndroidInjector<Any> {
        return  androidInjector
    }

    override fun onCreate() {
        super.onCreate()
        initInjection()
    }

    private fun initInjection(){
        applicationComponent = DaggerApplicationComponent.builder().application(this).build()
        applicationComponent.inject(this)
    }
}