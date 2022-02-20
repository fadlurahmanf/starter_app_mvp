package com.fadlurahmanf.starter_app_mvp.data.repository.example

import android.content.Context
import com.fadlurahmanf.starter_app_mvp.base.BasePreference
import com.fadlurahmanf.starter_app_mvp.data.response.example.TestimonialResponse
import javax.inject.Inject


class ExampleRepository @Inject constructor(
    var context: Context
):BasePreference(context) {

    companion object{
        //todo key
        const val TEXT1 = "TEXT1"
        const val INT1 = "INT1"
        const val OBJ1 = "OBJ1"
        const val LIST1 = "LIST1"
    }

    var text1:String ?= null
    get() {
        field = getData(TEXT1, classOfT = String::class.java)
        return field
    }
    set(value) {
        saveData(TEXT1, value)
        field = value
    }

    var int1:Int ?= null
    get(){
        field = getData(INT1, classOfT = Int::class.java)
        return field
    }
    set(value) {
        saveData(INT1, value)
        field = value
    }

    var obj1:TestimonialResponse ?= null
    get() {
        field = getData(OBJ1, TestimonialResponse::class.java)
        return field
    }
    set(value) {
        saveData(OBJ1, value)
        field = value
    }

    var list1:List<TestimonialResponse> ?= null
    get() {
        field = getDataList(LIST1, TestimonialResponse::class.java)
        return field
    }set(value) {
        saveData(LIST1, value)
        field = value
    }


}