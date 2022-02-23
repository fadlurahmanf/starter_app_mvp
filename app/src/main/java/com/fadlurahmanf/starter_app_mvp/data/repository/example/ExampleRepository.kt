package com.fadlurahmanf.starter_app_mvp.data.repository.example

import android.content.Context
import com.fadlurahmanf.starter_app_mvp.base.BasePreference
import com.fadlurahmanf.starter_app_mvp.core.constant.ParamsKeySP.DOUBLE1
import com.fadlurahmanf.starter_app_mvp.core.constant.ParamsKeySP.FLOAT1
import com.fadlurahmanf.starter_app_mvp.core.constant.ParamsKeySP.INT1
import com.fadlurahmanf.starter_app_mvp.core.constant.ParamsKeySP.LIST1
import com.fadlurahmanf.starter_app_mvp.core.constant.ParamsKeySP.LONG1
import com.fadlurahmanf.starter_app_mvp.core.constant.ParamsKeySP.OBJ1
import com.fadlurahmanf.starter_app_mvp.core.constant.ParamsKeySP.TEXT1
import com.fadlurahmanf.starter_app_mvp.data.response.example.TestimonialResponse
import java.util.ArrayList
import javax.inject.Inject


class ExampleRepository @Inject constructor(
    var context: Context
):BasePreference(context) {

    var text1:String ?= null
    get() {
        field = getString(TEXT1)
        return field
    }
    set(value) {
        if (value == null){
            clearData(TEXT1)
            field = null
        }else{
            saveString(TEXT1, value)
            field = value
        }
    }

    var int1:Int ?= null
    get(){
        field = getInt(INT1)
        return field
    }
    set(value) {
        if (value == null){
            clearData(INT1)
            field = null
        }else{
            saveInt(INT1, value)
            field = value
        }
    }

    var double1:Double ?= null
    get() {
        field = getDouble(DOUBLE1)
        return field
    }set(value) {
        if (value==null){
            clearData(DOUBLE1)
            field = null
        }else{
            saveDouble(DOUBLE1, value)
            field = value
        }
    }

    var float1:Float ?= null
    get() {
        field = getFloat(FLOAT1)
        return field
    }set(value) {
        if (value == null){
            clearData(FLOAT1)
            field = null
        }else{
            saveFloat(FLOAT1, value)
            field = value
        }
    }

    var long1:Long ?= null
    get() {
        field = getLong(LONG1)
        return field
    }set(value) {
        if (value==null){
            clearData(LONG1)
            field = null
        }else{
            saveLong(LONG1, value)
            field = value
        }
    }

    var obj1:TestimonialResponse ?= null
    get() {
        field = getData(OBJ1, TestimonialResponse::class.java)
        return field
    }
    set(value) {
        if (value == null){
            clearData(OBJ1)
            field = null
        }else{
            saveData(OBJ1, value)
            field = value
        }
    }

    var list1:List<TestimonialResponse> ?= null
    get() {
        field = getListData(LIST1, TestimonialResponse::class.java)
        return field
    }set(value) {
        if (value == null){
            clearData(LIST1)
            field = null
        }else{
            saveListData(LIST1, value as ArrayList<TestimonialResponse>)
            field = value
        }
    }


}