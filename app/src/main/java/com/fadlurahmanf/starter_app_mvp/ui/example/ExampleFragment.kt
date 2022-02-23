package com.fadlurahmanf.starter_app_mvp.ui.example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fadlurahmanf.starter_app_mvp.BaseApp
import com.fadlurahmanf.starter_app_mvp.R
import com.fadlurahmanf.starter_app_mvp.base.BaseFragment
import com.fadlurahmanf.starter_app_mvp.databinding.FragmentExampleBinding
import com.fadlurahmanf.starter_app_mvp.di.component.ExampleComponent

class ExampleFragment : BaseFragment<FragmentExampleBinding>(FragmentExampleBinding::inflate) {
    private lateinit var component: ExampleComponent

    override fun injectView() {
        component = (requireActivity().applicationContext as BaseApp).appComponent.exampleComponent().create()
        component.inject(this)
    }

    override fun setup() {

    }

}