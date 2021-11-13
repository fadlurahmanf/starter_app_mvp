package com.fadlurahmanf.starter_app_mvp.example

import com.fadlurahmanf.starter_app_mvp.BuildConfig
import com.fadlurahmanf.starter_app_mvp.base.BasePresenter
import com.fadlurahmanf.starter_app_mvp.example.dummyEntity.PostEntity
import com.fadlurahmanf.starter_app_mvp.extension.uiSubscribe
import javax.inject.Inject

class ExampleActivity1Presenter @Inject constructor(
    var postEntity:PostEntity
) : BasePresenter<ExampleActivity1Contract.View>(), ExampleActivity1Contract.Presenter {

    override fun getAllPost() {
        println("saas")
        addSubscription(postEntity.getAllPost().uiSubscribe(
            { view?.exampleViewSuccess(message = "SUKSES") },
            { view?.exampleViewError("ERROR") },
            { view?.exampleViewSuccess(message = "COMPLETE")/*TODO: WHEN FUNCTION COMPLETED*/   }
        ))
    }

    override fun setExampleViewError() {
        view?.exampleViewError(message = "ERROR")
    }

}