package com.fadlurahmanf.starter_app_mvp.data.api.example

import com.fadlurahmanf.starter_app_mvp.data.response.example.BaseResponse
import com.fadlurahmanf.starter_app_mvp.data.response.example.TestimonialResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface TestimonialApi {
    @GET("api/testimonial/all")
    fun getTestimonial() : Observable<BaseResponse<List<TestimonialResponse>>>
}