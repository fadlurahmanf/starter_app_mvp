package com.fadlurahmanf.starter_app_mvp.data.response.example

import com.google.gson.annotations.SerializedName

data class BaseResponse<T> (
    @SerializedName("code")
    var code:Int ?= null,
    @SerializedName("message")
    var message:String ?= null,
    @SerializedName("data")
    var data:T ?= null
)