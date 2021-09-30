package com.fadlurahmanf.starter_app_mvp.example

import com.fadlurahmanf.starter_app_mvp.base.BasePresenter
import javax.inject.Inject

class ExampleActivity1Presenter @Inject constructor()
    : BasePresenter<ExampleActivity1Contract.View>(), ExampleActivity1Contract.Presenter {

    override fun setExampleViewSuccess() {
        view?.exampleViewSuccess()
    }

    override fun setExampleViewError() {
        view?.exampleViewError()
    }

}