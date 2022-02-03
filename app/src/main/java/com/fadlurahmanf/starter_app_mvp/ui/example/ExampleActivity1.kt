package com.fadlurahmanf.starter_app_mvp.ui.example


import com.fadlurahmanf.starter_app_mvp.BaseApp
import com.fadlurahmanf.starter_app_mvp.base.BaseMvpActivity
import com.fadlurahmanf.starter_app_mvp.databinding.ActivityExample1Binding
import com.fadlurahmanf.starter_app_mvp.di.component.ActivityComponent
import javax.inject.Inject

// TES NEW BRANCH MVP 2
class ExampleActivity1 : BaseMvpActivity<ExampleActivity1Presenter>(), ExampleActivity1Contract.View {
    private lateinit var binding:ActivityExample1Binding
    lateinit var activityComponent:ActivityComponent

    override fun setLayout() {
        binding = ActivityExample1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun initPresenterView() {
        presenter.view = this
    }

    override fun injectView() {
        activityComponent = (applicationContext as BaseApp).appComponent.activityComponent().create()
        activityComponent.inject(this)
    }

    override fun setup() {
        binding.button1.setOnClickListener {
            presenter.setExampleViewError()
        }
    }

    @Inject
    lateinit var presenter: ExampleActivity1Presenter

    override fun exampleViewSuccess() {
        println("HALO")
    }

    override fun exampleViewError(message: String?) {
        println("HALO ERROR")
    }



}