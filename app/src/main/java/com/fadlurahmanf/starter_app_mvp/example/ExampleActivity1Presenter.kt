package com.fadlurahmanf.starter_app_mvp.example

import com.fadlurahmanf.starter_app_mvp.BuildConfig
import com.fadlurahmanf.starter_app_mvp.base.BasePresenter
import com.fadlurahmanf.starter_app_mvp.example.dummyEntity.PostEntity
import com.fadlurahmanf.starter_app_mvp.extension.uiSubscribe
import javax.inject.Inject

class ExampleActivity1Presenter @Inject constructor(
    val postEntity:PostEntity
) : BasePresenter<ExampleActivity1Contract.View>(), ExampleActivity1Contract.Presenter {

    override fun setExampleViewSuccess() {
        addSubscription(postEntity.getAllPost().uiSubscribe(
            {
                view?.exampleViewSuccess(message = it.size.toString())
            },
            {
                println("MASUK ON ERROR")
            },
            {
                // TODO: COMPLETE FUNCTION
            }
        ))
    }

    override fun setExampleViewError() {
        view?.exampleViewError(message = "ERROR")
    }

}