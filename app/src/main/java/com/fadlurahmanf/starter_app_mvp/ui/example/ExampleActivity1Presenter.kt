package com.fadlurahmanf.starter_app_mvp.ui.example

import com.fadlurahmanf.starter_app_mvp.base.BasePresenter
import com.fadlurahmanf.starter_app_mvp.data.entity.example.PostEntity
import com.fadlurahmanf.starter_app_mvp.core.extension.uiSubscribe
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


//tes branch 3
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