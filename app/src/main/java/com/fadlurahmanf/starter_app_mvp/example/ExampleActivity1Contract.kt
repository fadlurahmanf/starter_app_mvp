package com.fadlurahmanf.starter_app_mvp.example

import com.fadlurahmanf.starter_app_mvp.base.ErrorView

interface ExampleActivity1Contract {
    interface View:ErrorView{
        fun exampleViewSuccess()
        fun exampleViewError()
    }
    interface Presenter{
        fun examplePresenter1()
    }
}