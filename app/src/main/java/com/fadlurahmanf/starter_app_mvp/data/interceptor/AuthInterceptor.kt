package com.fadlurahmanf.starter_app_mvp.data.interceptor

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(
    // TODO ADD YOUR REPOSITORY //
):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var response = chain.proceed(chain.request())
        return response
    }

    private fun addHeader(request: Request):Request{
        return request.newBuilder()
            .addHeader("Authorization", "Bearer [TOKEN]")  // TODO ADD YOUR TOKEN HERE //
            .build()
    }
}