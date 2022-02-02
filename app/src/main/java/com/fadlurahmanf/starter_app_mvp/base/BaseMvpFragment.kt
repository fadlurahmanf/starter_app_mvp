package com.fadlurahmanf.starter_app_mvp.base

import androidx.viewbinding.ViewBinding

abstract class BaseMvpFragment<VB:ViewBinding, P:BasePresenter<*>>(
    private var inflate:Inflate<VB>
):BaseFragment<VB>(inflate) {
}