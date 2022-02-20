package com.fadlurahmanf.starter_app_mvp.base

import androidx.viewbinding.ViewBinding

abstract class BaseMvpActivity<T: BasePresenter<*>, VB:ViewBinding>(
    inflate:InflateLayoutActivity<VB>
): BaseActivity<VB>(inflate) {

    override fun internalSetup() {
        initPresenterView()
        super.internalSetup()
    }

    abstract fun initPresenterView()
}