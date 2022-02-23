package com.fadlurahmanf.starter_app_mvp.di.component

import com.fadlurahmanf.starter_app_mvp.ui.example.*
import dagger.Subcomponent

@Subcomponent
interface ExampleComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():ExampleComponent
    }

    fun inject(activity: ExampleActivity1)
    fun inject(fragment: ExampleFragment)

    fun inject(activity: FragmentActivity)
    fun inject(fragment: FirstFragment)
    fun inject(fragment: SecondFragment)
}