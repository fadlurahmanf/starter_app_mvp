package com.fadlurahmanf.starter_app_mvp.example

import com.fadlurahmanf.starter_app_mvp.BuildConfig
import com.fadlurahmanf.starter_app_mvp.base.BasePresenter
import com.fadlurahmanf.starter_app_mvp.example.dummyEntity.PostEntity
import com.fadlurahmanf.starter_app_mvp.extension.uiSubscribe
import javax.inject.Inject

class ExampleActivity1Presenter @Inject constructor(
    val postEntity:PostEntity
)
    : BasePresenter<ExampleActivity1Contract.View>(), ExampleActivity1Contract.Presenter {

    override fun setExampleViewSuccess() {
        addSubscription(postEntity.getPost().uiSubscribe(
            {
                println("MASUK ON NEXT")
            },
            {
                println("MASUK ON ERROR")
            },
            {
                println("MASUK ON COMPLETE")
            }
        ))
        view?.exampleViewSuccess()
    }

    override fun setExampleViewError() {
        view?.exampleViewError(message = BuildConfig.BASE_DEV_URL)
    }

}