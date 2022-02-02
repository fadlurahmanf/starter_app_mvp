package com.fadlurahmanf.starter_app_mvp.data.response.example

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("userId")
    var userId:Int,
    @SerializedName("title")
    var title:String,
    @SerializedName("body")
    var body:String
)