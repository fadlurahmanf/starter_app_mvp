package com.fadlurahmanf.starter_app_mvp.data.entity.example

import android.content.Context
import com.fadlurahmanf.starter_app_mvp.base.network.AuthAbstractNetwork
import com.fadlurahmanf.starter_app_mvp.data.api.example.TestimonialApi
import javax.inject.Inject

class ExampleAuthEntity @Inject constructor(
    private var context: Context
):AuthAbstractNetwork<TestimonialApi>(context) {
    override fun getApi(): Class<TestimonialApi> {
        return TestimonialApi::class.java
    }
}