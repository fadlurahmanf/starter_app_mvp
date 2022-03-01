package com.fadlurahmanf.starter_app_mvp.ui.core

import android.view.View
import com.fadlurahmanf.starter_app_mvp.R
import com.fadlurahmanf.starter_app_mvp.base.BaseDialog
import com.fadlurahmanf.starter_app_mvp.databinding.DialogOkBinding

class OkDialog:BaseDialog<DialogOkBinding>(DialogOkBinding::inflate) {

    private var okListener:() -> Unit = { dismiss() }

    companion object{
        const val TITLE = "TITLE"
        const val CONTENT = "CONTENT"
        const val IS_CANCELABLE = "IS_CANCELABLE"
        const val OK_TEXT = "OK_TEXT"
    }

    override fun setup() {
        initAction()
    }

    private fun initAction() {
        initData()
        binding?.btnOk?.setOnClickListener {
            okListener()
        }
    }

    fun setOkListener(okListener: () -> Unit){
        this.okListener = okListener
    }

    private fun initData(){
        val title: String?
        val content: String?
        val isCancelable: Boolean?
        val okText: String?

        val bundle = this.arguments

        title = bundle?.getString(TITLE, null)
        content = bundle?.getString(CONTENT, null)
        isCancelable = bundle?.getBoolean(IS_CANCELABLE, true)
        okText = bundle?.getString(OK_TEXT, "OK")

        if (title == null){
            binding?.tvTitle?.visibility = View.GONE
        }else{
            binding?.tvTitle?.visibility = View.VISIBLE
            binding?.tvTitle?.text = title
        }
        if (content == null){
            binding?.tvContent?.visibility = View.GONE
        }else{
            binding?.tvContent?.visibility = View.VISIBLE
            binding?.tvContent?.text = content
        }

        dialog?.setCancelable(isCancelable?:true)

        binding?.btnOk?.text = okText ?: "OK"
    }

    override fun injectView() {}

    override fun getTheme(): Int {
        return R.style.DialogAllRounded15
    }


}