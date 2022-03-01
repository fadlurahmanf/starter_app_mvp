package com.fadlurahmanf.starter_app_mvp.ui.example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fadlurahmanf.starter_app_mvp.BaseApp
import com.fadlurahmanf.starter_app_mvp.R
import com.fadlurahmanf.starter_app_mvp.base.BaseFragment
import com.fadlurahmanf.starter_app_mvp.core.event.ChangeText
import com.fadlurahmanf.starter_app_mvp.core.utils.RxBus
import com.fadlurahmanf.starter_app_mvp.data.repository.example.ExampleRepository
import com.fadlurahmanf.starter_app_mvp.databinding.FragmentSecondBinding
import com.fadlurahmanf.starter_app_mvp.di.component.ExampleComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {
    private lateinit var component: ExampleComponent

    override fun injectView() {
        component = (requireActivity().applicationContext as BaseApp).appComponent.exampleComponent().create()
        component.inject(this)
    }

    @Inject
    lateinit var exampleRepository: ExampleRepository

    override fun setup() {
        binding?.tv?.text = exampleRepository.text1
        initObserver()
    }

    private fun initObserver() {
        CompositeDisposable().add(RxBus.listen(ChangeText::class.java).subscribe {
            setText()
        })
    }

    private fun setText() {
        binding?.tv?.text = exampleRepository.text1
    }

}