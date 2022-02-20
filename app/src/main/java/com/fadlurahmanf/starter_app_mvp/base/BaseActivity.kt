package com.fadlurahmanf.starter_app_mvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

typealias InflateLayoutActivity<T> = (LayoutInflater) -> T

abstract class BaseActivity<VB:ViewBinding>(
    var inflate:InflateLayoutActivity<VB>
):AppCompatActivity(), BaseView {

    private var _binding:VB ?= null
    val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        injectView()
        super.onCreate(savedInstanceState)
        setLayout()
        internalSetup()
        setup()
    }

    abstract fun injectView()

    private fun setLayout(){
        _binding = inflate.invoke(layoutInflater)
        setContentView(binding?.root)
    }

    abstract fun setup()

    open fun internalSetup(){}

    override fun errorScreen(message: String?) {
        Toast.makeText(this, "ERROR SCREEN : $message", Toast.LENGTH_SHORT).show()
    }

    override fun errorConnection() {}
}