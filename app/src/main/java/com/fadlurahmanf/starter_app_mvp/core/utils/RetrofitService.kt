package com.fadlurahmanf.starter_app_mvp.core.utils

import android.content.Context
import com.fadlurahmanf.starter_app_mvp.BuildConfig
import com.fadlurahmanf.starter_app_mvp.data.interceptor.ConnectivityInterceptor
import com.fadlurahmanf.starter_app_mvp.data.interceptor.ExceptionInterceptor
import com.fadlurahmanf.starter_app_mvp.data.response.example.BaseResponse
import com.fadlurahmanf.starter_app_mvp.data.response.example.TestimonialResponse
import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


object WorkRetrofitServices {

    fun services(context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_DEV_URL)
            .client(provideClient(context))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    private fun provideClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ExceptionInterceptor())
            .addInterceptor(ConnectivityInterceptor(context))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }
}

interface ExampleApiWorkService{
    @GET("api/testimonial/all")
    fun getTestimonialCoroutine() :  Call<BaseResponse<List<TestimonialResponse>>>

    @GET("api/testimonial/alL")
    fun getTestimonialObservable() : Observable<BaseResponse<List<TestimonialResponse>>>
}