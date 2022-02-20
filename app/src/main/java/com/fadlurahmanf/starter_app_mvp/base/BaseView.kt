package com.fadlurahmanf.starter_app_mvp.base

interface BaseView {
    fun errorScreen(message:String?="")
    fun errorConnection()
}