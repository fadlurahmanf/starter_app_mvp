package com.fadlurahmanf.starter_app_mvp.di.component

import android.content.Context
import com.fadlurahmanf.starter_app_mvp.ui.example.ExampleActivity1
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@Subcomponent
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():ActivityComponent
    }

    fun inject(exampleActivity1: ExampleActivity1)
}