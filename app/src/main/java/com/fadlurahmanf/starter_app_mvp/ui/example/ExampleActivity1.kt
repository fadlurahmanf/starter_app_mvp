package com.fadlurahmanf.starter_app_mvp.ui.example


import com.fadlurahmanf.starter_app_mvp.BaseApp
import com.fadlurahmanf.starter_app_mvp.base.BaseMvpActivity
import com.fadlurahmanf.starter_app_mvp.data.repository.example.ExampleRepository
import com.fadlurahmanf.starter_app_mvp.databinding.ActivityExample1Binding
import com.fadlurahmanf.starter_app_mvp.di.component.ExampleComponent
import javax.inject.Inject

// TES NEW BRANCH MVP 2
class ExampleActivity1 : BaseMvpActivity<ExampleActivity1Presenter>(), ExampleActivity1Contract.View {
    private lateinit var binding:ActivityExample1Binding
    lateinit var exampleComponent:ExampleComponent

    override fun setLayout() {
        binding = ActivityExample1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun initPresenterView() {
        presenter.view = this
    }

    override fun injectView() {
        exampleComponent = (applicationContext as BaseApp).appComponent.exampleComponent().create()
        exampleComponent.inject(this)
    }

    @Inject
    lateinit var exampleRepository: ExampleRepository

    override fun setup() {
        binding.button1.setOnClickListener {
            exampleRepository.list1?.forEach {
                println("MASUK ${it.data}")
            }
        }
    }

    @Inject
    lateinit var presenter: ExampleActivity1Presenter

    override fun exampleViewSuccess() {
        //todo when example view success
    }

    override fun exampleViewError(message: String?) {
        //todo when example view error
    }



}