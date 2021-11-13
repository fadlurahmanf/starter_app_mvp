package com.fadlurahmanf.starter_app_mvp.example

import com.fadlurahmanf.starter_app_mvp.base.ErrorView

interface ExampleActivity1Contract {
    interface View:ErrorView{
        fun exampleViewSuccess(message: String?="")
        fun exampleViewError(message:String?="")
    }
    interface Presenter{
        fun getAllPost()
        fun setExampleViewError()
    }
}