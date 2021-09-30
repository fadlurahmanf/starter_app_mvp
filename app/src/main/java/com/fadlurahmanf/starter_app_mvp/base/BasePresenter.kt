package com.fadlurahmanf.starter_app_mvp.base

open class BasePresenter<T: ErrorView> {
    var view:T ?= null

    open fun detachView(){
        this.view = null
    }
}