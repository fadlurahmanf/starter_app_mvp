package com.fadlurahmanf.starter_app_mvp

import android.content.Intent
import android.os.Bundle
import com.fadlurahmanf.starter_app_mvp.base.BaseActivity
import com.fadlurahmanf.starter_app_mvp.data.repository.example.ExampleRepository
import com.fadlurahmanf.starter_app_mvp.data.response.example.ExampleResponse
import com.fadlurahmanf.starter_app_mvp.data.response.example.PostResponse
import com.fadlurahmanf.starter_app_mvp.databinding.ActivityMainBinding
import com.fadlurahmanf.starter_app_mvp.di.module.MainComponent
import com.fadlurahmanf.starter_app_mvp.ui.example.ExampleActivity1
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    lateinit var mainComponent: MainComponent

    override fun injectView() {
        mainComponent = (applicationContext as BaseApp).appComponent.mainComponent().create()
        mainComponent.inject(this)
    }

    @Inject
    lateinit var exampleRepository: ExampleRepository

    override fun setup() {
        binding?.button1?.setOnClickListener {
            val intent = Intent(this, ExampleActivity1::class.java)
            startActivity(intent)
        }
    }
}