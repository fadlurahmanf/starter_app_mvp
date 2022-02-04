package com.fadlurahmanf.starter_app_mvp.di.module

import com.fadlurahmanf.starter_app_mvp.MainActivity
import dagger.Subcomponent

@Subcomponent
interface MainComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():MainComponent
    }

    fun inject(mainActivity: MainActivity)
}