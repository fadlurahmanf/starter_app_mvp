package com.fadlurahmanf.starter_app_mvp.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity(), ErrorView {

    override fun onCreate(savedInstanceState: Bundle?) {
        injectView()
        super.onCreate(savedInstanceState)
        setLayout()
        internalSetup()
        setup()
    }

    abstract fun injectView()

    abstract fun setLayout()

    abstract fun setup()

    open fun internalSetup(){}

    override fun errorScreen(message: String?) {
        Toast.makeText(this, "ERROR SCREEN : $message", Toast.LENGTH_SHORT).show()
    }

    override fun errorConnection() {}
}