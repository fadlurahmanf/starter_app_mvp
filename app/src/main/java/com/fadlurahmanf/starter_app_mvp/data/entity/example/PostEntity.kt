package com.fadlurahmanf.starter_app_mvp.data.entity.example

import android.content.Context
import com.fadlurahmanf.starter_app_mvp.base.network.AbstractNetwork
import com.fadlurahmanf.starter_app_mvp.data.api.example.PostApi
import javax.inject.Inject

class PostEntity @Inject constructor(
    var context: Context
) : AbstractNetwork<PostApi>(context){
    override fun getApi(): Class<PostApi> {
        return PostApi::class.java
    }

    fun getPost() = networkService(30).getPost()
    fun getAllPost() = networkService(30).getAllPost()
}