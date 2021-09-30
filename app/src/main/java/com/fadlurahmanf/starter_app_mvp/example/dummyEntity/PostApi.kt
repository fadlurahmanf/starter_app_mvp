package com.fadlurahmanf.starter_app_mvp.example.dummyEntity

import io.reactivex.rxjava3.core.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    fun getAllPost() : Observable<List<PostResponse>>
    @GET("posts/2")
    fun getPost() : Observable<PostResponse>
}