package com.fadlurahmanf.starter_app_mvp.core.extension

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

fun<T: Any> Observable<T>.uiSubscribe(onNext: (T) -> Unit = {},
                                       onError:(Throwable) -> Unit = {},
                                       onComplete: () -> Unit = {}) : Disposable {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(onNext, onError, onComplete)
}