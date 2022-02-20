package com.fadlurahmanf.starter_app_mvp.ui.example

import com.fadlurahmanf.starter_app_mvp.base.BasePresenter
import com.fadlurahmanf.starter_app_mvp.core.extension.uiSubscribe
import com.fadlurahmanf.starter_app_mvp.data.entity.example.TestimonialEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.RuntimeException
import java.net.SocketTimeoutException
import javax.inject.Inject

class ExampleActivity1Presenter @Inject constructor(
    private var testimonialEntity: TestimonialEntity
) : BasePresenter<ExampleActivity1Contract.View>(), ExampleActivity1Contract.Presenter {

    override fun getAllPost() {
        addSubscription(
            testimonialEntity.getTestimonial().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                    {
                        view?.exampleViewSuccess()
                    },
                    {
                        view?.exampleViewError(it.message)
                    },
                    {}
                )
        )

//        addSubscription(testimonialEntity.getTestimonial().uiSubscribe(
//            {
//                view?.exampleViewSuccess()
//            },
//            {
//                view?.exampleViewError(it.message)
//            },
//            {  }
//        ))
    }

}