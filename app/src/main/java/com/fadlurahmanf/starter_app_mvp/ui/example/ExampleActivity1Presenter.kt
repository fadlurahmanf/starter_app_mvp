package com.fadlurahmanf.starter_app_mvp.ui.example

import com.fadlurahmanf.starter_app_mvp.base.BasePresenter
import com.fadlurahmanf.starter_app_mvp.data.entity.example.PostEntity
import com.fadlurahmanf.starter_app_mvp.extension.uiSubscribe
import javax.inject.Inject

class ExampleActivity1Presenter @Inject constructor(
    private var postEntity: PostEntity
) : BasePresenter<ExampleActivity1Contract.View>(), ExampleActivity1Contract.Presenter {

    override fun getAllPost() {
        addSubscription(postEntity.getAllPost().uiSubscribe(
            {
                view?.exampleViewSuccess()
            },
            {
                println("MASUK ${it.message} dan ${it.localizedMessage}")
                view?.exampleViewError("ERROR")
            },
            { /*TODO: WHEN FUNCTION COMPLETED*/   }
        ))
    }

    override fun setExampleViewError() {
        view?.exampleViewError(message = "ERROR")
    }

}