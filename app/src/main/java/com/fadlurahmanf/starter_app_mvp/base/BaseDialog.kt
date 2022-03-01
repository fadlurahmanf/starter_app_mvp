package com.fadlurahmanf.starter_app_mvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class BaseDialog<VB:ViewBinding>(
    var inflateFragment:InflateFragment<VB>
):DialogFragment() {

    private var _binding: VB ?= null
    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateFragment.invoke(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectView()
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    abstract fun setup()

    abstract fun injectView()
}