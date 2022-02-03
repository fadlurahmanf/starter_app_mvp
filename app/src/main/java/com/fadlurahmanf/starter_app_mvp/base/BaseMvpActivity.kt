package com.fadlurahmanf.starter_app_mvp.base

abstract class BaseMvpActivity<T: BasePresenter<*>>: BaseActivity() {

    override fun internalSetup() {
        initPresenterView()
        super.internalSetup()
    }

    abstract fun initPresenterView()
}