package com.fadlurahmanf.starter_app_mvp.base

import androidx.viewbinding.ViewBinding

abstract class BaseMvpFragment<VB:ViewBinding, P:BasePresenter<*>>(
    private var inflateFragment:InflateFragment<VB>
):BaseFragment<VB>(inflateFragment) {
}