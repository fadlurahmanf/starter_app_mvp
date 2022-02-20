package com.fadlurahmanf.starter_app_mvp.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException
import java.lang.Exception
import java.net.SocketTimeoutException
import javax.inject.Singleton

@Singleton
class ExceptionInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        try {
            var response = chain.proceed(request)
            var responseBody = response.peekBody(Long.MAX_VALUE).string()
            var jsonResponse = JSONObject(responseBody)
            if (jsonResponse.optInt("code") == 999){
                throw IOException("Connection Lost. Please try again later")
            }else{
                return response
            }
        }catch (e:Exception){
            if (e is SocketTimeoutException){
                throw SocketTimeoutException("Socket timeout. Please try again later")
            }else{
                throw e
            }
        }
    }
}