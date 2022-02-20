package com.fadlurahmanf.starter_app_mvp.ui.example

import com.fadlurahmanf.starter_app_mvp.base.BasePresenter
import com.fadlurahmanf.starter_app_mvp.core.extension.uiSubscribe
import com.fadlurahmanf.starter_app_mvp.data.entity.example.TestimonialEntity
import javax.inject.Inject

class ExampleActivity1Presenter @Inject constructor(
    private var testimonialEntity: TestimonialEntity
) : BasePresenter<ExampleActivity1Contract.View>(), ExampleActivity1Contract.Presenter {

    override fun getAllPost() {

        addSubscription(testimonialEntity.getTestimonial().uiSubscribe(
            {
                view?.exampleViewSuccess()
            },
            {
                view?.exampleViewError(it.message)
            },
            {  }
        ))
    }

}