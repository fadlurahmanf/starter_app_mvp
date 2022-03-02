package com.fadlurahmanf.starter_app_mvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetFragment<VB:ViewBinding>(
    var inflate:InflateFragment<VB>
):BottomSheetDialogFragment() {

    private var _binding:VB ?= null
    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectView()
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    abstract fun injectView()

    abstract fun setup()
}