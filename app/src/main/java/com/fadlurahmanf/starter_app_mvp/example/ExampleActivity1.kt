package com.fadlurahmanf.starter_app_mvp.example

import android.app.Activity
import com.fadlurahmanf.starter_app_mvp.base.BaseMvpActivity
import com.fadlurahmanf.starter_app_mvp.databinding.ActivityExample1Binding
import dagger.android.AndroidInjection
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

// TODO: 30/09/2021 EXAMPLE ACTIVITY FOR BASE ACTIVITY
class ExampleActivity1 : BaseMvpActivity<ExampleActivity1Presenter>(), ExampleActivity1Contract.View {
    private lateinit var binding:ActivityExample1Binding

    companion object{
        fun newInstancce(activity:Activity){
            activity.startActivity<ExampleActivity1>()
        }
    }

    @Inject
    override lateinit var presenter: ExampleActivity1Presenter

    override fun injectView() {
        AndroidInjection.inject(this)
    }

    override fun setLayout() {
        binding = ActivityExample1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun setup() {
        binding.button1.setOnClickListener {
            presenter.setExampleViewSuccess()
        }

        binding.button2.setOnClickListener {
            presenter.setExampleViewError()
        }
    }


    override fun initPresenterView() {
        presenter.view = this
    }

    override fun exampleViewSuccess() {
        toast("EXAMPLE VIEW SUCCESS")
    }

    override fun exampleViewError() {
        toast("EXAMPLE VIEW ERROR")
    }
}