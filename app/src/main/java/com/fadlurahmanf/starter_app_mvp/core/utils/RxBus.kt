package com.fadlurahmanf.starter_app_mvp.core.utils

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject

object RxBus{
    private var publisher = PublishSubject.create<Any>()

    fun publish(event:Any){
        publisher.onNext(event)
    }

    fun<T> listen(classOfT:Class<T>) : Observable<T> = publisher.ofType(classOfT)
}