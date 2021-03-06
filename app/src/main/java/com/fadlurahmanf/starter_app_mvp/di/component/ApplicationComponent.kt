package com.fadlurahmanf.starter_app_mvp.di.component

import android.app.Application
import com.fadlurahmanf.starter_app_mvp.BaseApp
import com.fadlurahmanf.starter_app_mvp.di.builder.ActivityBuilder
import com.fadlurahmanf.starter_app_mvp.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ApplicationModule::class, ActivityBuilder::class]) // TODO: ADD YOUR MODULES HERE //
interface ApplicationComponent {
    fun inject(baseApp: BaseApp)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}