package com.fadlurahmanf.starter_app_mvp.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.fadlurahmanf.starter_app_mvp.core.constant.ParamsKeySP
import com.google.gson.Gson
import org.json.JSONArray
import java.lang.Exception

abstract class BasePreference(context: Context) {
    private var sharedPreferences: SharedPreferences ?= null

    init {
        sharedPreferences = context.getSharedPreferences(ParamsKeySP.PARAMS_SP_KEY, Context.MODE_PRIVATE)
    }

    protected fun saveString(key:String, value:String){
        sharedPreferences?.edit()?.putString(key, value)?.apply()
    }

    protected fun getString(key: String):String?{
        return sharedPreferences?.getString(key, null)
    }

    protected fun saveInt(key: String, value: Int?){
        if (value != null){
            sharedPreferences?.edit()?.putString(key, value.toString())?.apply()
        }
    }

    protected fun getInt(key: String):Int?{
        return try {
            var raw = sharedPreferences?.getString(key, null)
            when{
                raw != null -> raw.toInt()
                else -> null
            }
        }catch (e:Exception){
            null
        }
    }

    protected fun saveLong(key: String, value: Long?){
        if (value!=null){
            sharedPreferences?.edit()?.putString(key, value.toString())?.apply()
        }
    }

    protected fun getLong(key: String):Long?{
        return try {
            var raw = sharedPreferences?.getString(key, null)
            when{
                raw != null -> raw.toLong()
                else -> null
            }
        }catch (e:Exception){
            null
        }
    }

    protected fun saveFloat(key: String, value: Float?){
        if (value!=null){
            sharedPreferences?.edit()?.putString(key, value.toString())?.apply()
        }
    }

    protected fun getFloat(key: String):Float?{
        return try {
            var raw = sharedPreferences?.getString(key, null)
            when{
                raw != null -> raw.toFloat()
                else -> null
            }
        }catch (e:Exception){
            null
        }
    }

    protected fun saveDouble(key: String, value: Double?){
        if (value!=null){
            sharedPreferences?.edit()?.putString(key, value.toString())?.apply()
        }
    }

    protected fun getDouble(key: String):Double?{
        return try {
            var raw = sharedPreferences?.getString(key, null)
            when{
                raw != null -> raw.toDouble()
                else -> null
            }
        }catch (e:Exception){
            null
        }
    }

    protected fun <T> saveData(key: String, value:T?){
        if (!Gson().toJson(value).isNullOrEmpty()){
            sharedPreferences?.edit()?.putString(key, Gson().toJson(value))?.apply()
        }
    }

    protected fun <T> getData(key: String, classOfT:Class<T>): T?{
        return try {
            var rawString:String? = getString(key)
            if (rawString != null){
                Gson().fromJson(rawString, classOfT)
            }else{
                null
            }
        }catch (e:Exception){
            null
        }
    }

    protected fun <T> saveListData(key: String, value: ArrayList<T>){
        sharedPreferences?.edit()?.putString(key, Gson().toJson(value))?.apply()
    }

    protected fun <T> getListData(key: String, classOfT:Class<T>): ArrayList<T>?{
        try {
            var rawString:String? = getString(key)
            var list:ArrayList<T> = arrayListOf<T>()
            list.clear()
            if (rawString!=null){
                var jsonArray = JSONArray(rawString)
                for (i in 0 until jsonArray.length()){
                    var row = jsonArray.getJSONObject(i)
                    list.add(Gson().fromJson(row.toString(), classOfT))
                }
                return list
            }else{
                return null
            }
        }catch (e:Exception){
            return null
        }
    }

    protected fun clearData(key: String){
        sharedPreferences?.edit()?.remove(key)?.apply()
    }
}