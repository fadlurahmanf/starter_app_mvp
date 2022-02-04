package com.fadlurahmanf.starter_app_mvp.di.component

import android.content.Context
import com.fadlurahmanf.starter_app_mvp.BaseApp
import com.fadlurahmanf.starter_app_mvp.di.module.ExampleComponentModule
import com.fadlurahmanf.starter_app_mvp.di.module.MainComponent
import dagger.BindsInstance
import dagger.Component


@Component(modules = [ExampleComponentModule::class])
interface ApplicationComponent {
    fun inject(app:BaseApp)

    fun exampleComponent(): ExampleComponent.Factory
    fun mainComponent():MainComponent.Factory

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context):ApplicationComponent
    }
}