package com.fadlurahmanf.starter_app_mvp.base

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.fadlurahmanf.starter_app_mvp.core.services.ConnectivityReceiver
import com.google.android.material.snackbar.Snackbar

typealias InflateLayoutActivity<T> = (LayoutInflater) -> T

abstract class BaseActivity<VB:ViewBinding>(
    var inflate:InflateLayoutActivity<VB>
):AppCompatActivity(), BaseView, ConnectivityReceiver.ConnectivityListener {

    private var _binding:VB ?= null
    val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        injectView()
        super.onCreate(savedInstanceState)
        setLayout()
        internalSetup()
        setup()
    }

    override fun onStart() {
        super.onStart()
        startConnectivityReceiver()
    }

    override fun onResume() {
        super.onResume()
        startConnectivityReceiver()
    }

    override fun onStop() {
        super.onStop()
        if (connectivityReceiver!=null){
            unregisterReceiver(connectivityReceiver)
            connectivityReceiver = null
        }
    }

    override fun onPause() {
        super.onPause()
        if (connectivityReceiver!=null){
            unregisterReceiver(connectivityReceiver)
            connectivityReceiver = null
        }
    }

    abstract fun injectView()

    private fun setLayout(){
        _binding = inflate.invoke(layoutInflater)
        setContentView(binding?.root)
    }

    abstract fun setup()

    open fun internalSetup(){}

    override fun errorScreen(message: String?) {
        Toast.makeText(this, message?:"Connection Lost. Please try again later", Toast.LENGTH_SHORT).show()
    }

    override fun errorConnection() {}

    private var connectivityReceiver:ConnectivityReceiver ?= null

    open fun startConnectivityReceiver(){
        if (connectivityReceiver==null){
            connectivityReceiver = ConnectivityReceiver()
            connectivityReceiver?.connectivityListener = this
            registerReceiver(connectivityReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        }
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if (connectivityReceiver != null){
            if (!isConnected){
                Snackbar.make(binding!!.root, "You are going offline", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}