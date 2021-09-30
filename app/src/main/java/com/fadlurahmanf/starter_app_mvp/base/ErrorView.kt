package com.fadlurahmanf.starter_app_mvp.base

interface ErrorView {
    fun errorScreen(message:String?="")
    fun errorConnection()
}