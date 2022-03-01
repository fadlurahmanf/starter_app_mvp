package com.fadlurahmanf.starter_app_mvp.base

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.fadlurahmanf.starter_app_mvp.core.services.ConnectivityReceiver
import com.fadlurahmanf.starter_app_mvp.ui.core.ConfirmDialog
import com.fadlurahmanf.starter_app_mvp.ui.core.OkDialog
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
        showSnackBar(message)
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
                showSnackBar("You are going offline", Snackbar.LENGTH_LONG)
            }
        }
    }

    private var okDialog:OkDialog ?= null
    open fun showOkDialog(
        title:String ?= null,
        content:String ?= null,
        isCancelable:Boolean = true,
        okText:String ?= null,
        okListener:() -> Unit ?= {dismissOkDialog()}
    ){
        if (okDialog == null){
            okDialog = OkDialog()
            val bundle = Bundle()
            bundle.putString(OkDialog.TITLE, title)
            bundle.putString(OkDialog.CONTENT, content)
            bundle.putBoolean(OkDialog.IS_CANCELABLE, isCancelable)
            bundle.putString(OkDialog.OK_TEXT, okText)
            okDialog?.arguments = bundle
            okDialog?.setOkListener {
                okListener()
            }
            okDialog?.show(supportFragmentManager, OkDialog::class.java.simpleName)
        }
    }

    open fun dismissOkDialog(){
        if (okDialog != null){
            okDialog?.dismiss()
            okDialog = null
        }
    }

    private var confirmDialog:ConfirmDialog ?= null
    open fun showConfirmDialog(
        title:String ?= null,
        content:String ?= null,
        isCancelable:Boolean = true,
        cancelText:String ?= null,
        confirmText:String ?= null,
        cancelListener:() -> Unit ?= {dismissConfirmDialog()},
        confirmListener:() -> Unit ?= {dismissConfirmDialog()}
    ){
        if (confirmDialog == null){
            confirmDialog = ConfirmDialog()
            val bundle = Bundle()
            bundle.putString(ConfirmDialog.TITLE, title)
            bundle.putString(ConfirmDialog.CONTENT, content)
            bundle.putBoolean(ConfirmDialog.IS_CANCELABLE, isCancelable)
            bundle.putString(ConfirmDialog.CANCEL_TEXT, cancelText)
            bundle.putString(ConfirmDialog.CONFIRM_TEXT, confirmText)
            confirmDialog?.arguments = bundle
            confirmDialog?.show(supportFragmentManager, ConfirmDialog::class.java.simpleName)
        }
    }

    open fun dismissConfirmDialog(){
        if (confirmDialog != null){
            confirmDialog?.dismiss()
            confirmDialog = null
        }
    }

    open fun showSnackBar(message: String?, typeLong:Int?=null){
        Snackbar.make(binding!!.root, message?:"", typeLong?:Snackbar.LENGTH_LONG).show()
    }
}