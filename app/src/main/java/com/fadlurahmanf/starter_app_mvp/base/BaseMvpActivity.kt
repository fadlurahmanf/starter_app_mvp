package com.fadlurahmanf.starter_app_mvp.base

abstract class BaseMvpActivity<T: BasePresenter<*>>: BaseActivity() {
    protected abstract var presenter : T

    override fun internalSetup() {
        initPresenterView()
        super.internalSetup()
    }

    abstract fun initPresenterView()
}