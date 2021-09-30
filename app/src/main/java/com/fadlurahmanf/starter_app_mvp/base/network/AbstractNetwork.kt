package com.fadlurahmanf.starter_app_mvp.base.network

import android.content.Context
import com.fadlurahmanf.starter_app_mvp.BuildConfig
import com.fadlurahmanf.starter_app_mvp.di.module.BaseNetwork

abstract class AbstractNetwork<T>():BaseNetwork<T>() {

    override fun getBaseUrl() = BuildConfig.BASE_DEV_URL
}