package com.fadlurahmanf.starter_app_mvp.example

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fadlurahmanf.starter_app_mvp.R
import com.fadlurahmanf.starter_app_mvp.base.BaseActivity
import com.fadlurahmanf.starter_app_mvp.base.BaseMvpActivity
import com.fadlurahmanf.starter_app_mvp.databinding.ActivityExample1Binding
import dagger.android.AndroidInjection
import org.jetbrains.anko.startActivity
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
    }


    override fun initPresenterView() {
        presenter.view = this
    }

    override fun exampleViewSuccess() {
//        TODO("Not yet implemented")
    }

    override fun exampleViewError() {
//        TODO("Not yet implemented")
    }
}