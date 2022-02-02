package com.fadlurahmanf.starter_app_mvp.base.network

import android.content.Context
import com.fadlurahmanf.starter_app_mvp.BuildConfig
import com.fadlurahmanf.starter_app_mvp.data.interceptor.ConnectivityInterceptor
import okhttp3.OkHttpClient

abstract class AbstractNetwork<T>(
    private var context: Context
): BaseNetwork<T>() {

    override fun getBaseUrl() = BuildConfig.BASE_DEV_URL

    override fun okHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        builder.addInterceptor(ConnectivityInterceptor(context = context))
        return super.okHttpClientBuilder(builder)
    }
}