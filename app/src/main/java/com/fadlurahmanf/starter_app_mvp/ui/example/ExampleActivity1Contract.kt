package com.fadlurahmanf.starter_app_mvp.ui.example

import com.fadlurahmanf.starter_app_mvp.base.BaseView

interface ExampleActivity1Contract {
    interface View:BaseView{
        fun exampleViewSuccess()
        fun exampleViewError(message:String?="")
    }
    interface Presenter{
        fun getAllPost()
    }
}