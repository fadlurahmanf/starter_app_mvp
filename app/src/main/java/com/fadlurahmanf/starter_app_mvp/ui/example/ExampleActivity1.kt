package com.fadlurahmanf.starter_app_mvp.ui.example

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.fadlurahmanf.starter_app_mvp.BaseApp
import com.fadlurahmanf.starter_app_mvp.base.BaseActivity
import com.fadlurahmanf.starter_app_mvp.base.BaseMvpActivity
import com.fadlurahmanf.starter_app_mvp.databinding.ActivityExample1Binding
import javax.inject.Inject

// TES NEW BRANCH MVP 2
class ExampleActivity1 : BaseActivity(), ExampleActivity1Contract.View {
    private lateinit var binding:ActivityExample1Binding

    override fun setLayout() {
        binding = ActivityExample1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun setup() {
        (applicationContext as BaseApp).appComponent.activityComponent().create().inject(this)
        halo.view = this
        binding.button1.setOnClickListener {
            halo.setExampleViewError()
        }
    }

    @Inject
    lateinit var halo: ExampleActivity1Presenter

    override fun exampleViewSuccess() {
        println("HALO")
    }

    override fun exampleViewError(message: String?) {
        println("HALO")
    }

}