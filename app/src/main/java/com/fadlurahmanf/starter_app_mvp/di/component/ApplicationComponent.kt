package com.fadlurahmanf.starter_app_mvp.di.component

import android.content.Context
import com.fadlurahmanf.starter_app_mvp.BaseApp
import com.fadlurahmanf.starter_app_mvp.di.module.SubComponentModule
import dagger.BindsInstance
import dagger.Component


@Component(modules = [SubComponentModule::class])
interface ApplicationComponent {
    fun inject(app:BaseApp)

    fun activityComponent(): ActivityComponent.Factory

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context):ApplicationComponent
    }
}