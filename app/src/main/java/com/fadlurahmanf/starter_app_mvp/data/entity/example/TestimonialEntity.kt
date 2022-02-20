package com.fadlurahmanf.starter_app_mvp.data.entity.example

import android.content.Context
import com.fadlurahmanf.starter_app_mvp.base.network.AbstractNetwork
import com.fadlurahmanf.starter_app_mvp.data.api.example.TestimonialApi
import javax.inject.Inject

class TestimonialEntity @Inject constructor(
    var context: Context
) : AbstractNetwork<TestimonialApi>(context){
    override fun getApi(): Class<TestimonialApi> {
        return TestimonialApi::class.java
    }

    fun getTestimonial() = networkService(30).getTestimonial()
}