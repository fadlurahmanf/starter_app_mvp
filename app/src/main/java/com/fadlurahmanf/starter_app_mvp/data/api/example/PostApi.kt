package com.fadlurahmanf.starter_app_mvp.data.api.example

import com.fadlurahmanf.starter_app_mvp.data.response.example.PostResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    fun getAllPost() : Observable<List<PostResponse>>
    @GET("posts/2")
    fun getPost() : Observable<PostResponse>
}