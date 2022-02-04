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

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mainComponent: MainComponent

    override fun injectView() {
        mainComponent = (applicationContext as BaseApp).appComponent.mainComponent().create()
        mainComponent.inject(this)
    }

    override fun setLayout() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    @Inject
    lateinit var exampleRepository: ExampleRepository

    override fun setup() {
        binding.tvId.setOnClickListener {
            exampleRepository.list1 = null
            val intent = Intent(this, ExampleActivity1::class.java)
            startActivity(intent)
        }
    }
}