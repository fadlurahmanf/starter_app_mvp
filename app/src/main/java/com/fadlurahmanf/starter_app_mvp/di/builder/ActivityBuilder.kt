package com.fadlurahmanf.starter_app_mvp.di.builder

import com.fadlurahmanf.starter_app_mvp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity():MainActivity
}