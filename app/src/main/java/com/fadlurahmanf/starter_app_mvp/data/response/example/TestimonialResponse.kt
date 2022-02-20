package com.fadlurahmanf.starter_app_mvp.data.response.example

import com.google.gson.annotations.SerializedName

data class TestimonialResponse(
    @SerializedName("id")
    var id:Int ?= null,
    @SerializedName("country_id")
    var countryId:Int ?= null ,
    @SerializedName("name")
    var name:String ?= null,
    @SerializedName("ocupation")
    var occupation:String ?= null,
    @SerializedName("quote")
    var quote:String ?= null,
    @SerializedName("anonymous")
    var anonymous:String ?= null
)
