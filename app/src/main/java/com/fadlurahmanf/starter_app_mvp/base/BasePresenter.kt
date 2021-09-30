package com.fadlurahmanf.starter_app_mvp.base

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BasePresenter<T: ErrorView> {
    var view:T ?= null

    open fun detachView(){
        this.view = null
    }

    fun addSubscription(disposable:Disposable) = CompositeDisposable().add(disposable)
}