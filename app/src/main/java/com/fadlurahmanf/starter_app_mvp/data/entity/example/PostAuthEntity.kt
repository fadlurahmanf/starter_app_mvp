package com.fadlurahmanf.starter_app_mvp.data.entity.example

import android.content.Context
import com.fadlurahmanf.starter_app_mvp.base.network.AuthAbstractNetwork
import com.fadlurahmanf.starter_app_mvp.data.api.example.PostApi
import javax.inject.Inject

class PostAuthEntity @Inject constructor(
    private var context: Context
):AuthAbstractNetwork<PostApi>(context) {
    override fun getApi(): Class<PostApi> {
        return PostApi::class.java
    }
}