package com.fadlurahmanf.starter_app_mvp.example.dummyEntity

import com.fadlurahmanf.starter_app_mvp.base.network.AbstractNetwork
import javax.inject.Inject

class PostEntity @Inject constructor() : AbstractNetwork<PostApi>(){
    override fun getApi(): Class<PostApi> {
        return PostApi::class.java
    }

    fun getPost() = networkService(30).getPost()
    fun getAllPost() = networkService(30).getAllPost()
}