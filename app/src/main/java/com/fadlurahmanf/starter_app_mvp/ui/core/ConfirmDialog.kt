package com.fadlurahmanf.starter_app_mvp.ui.core

import android.view.View
import com.fadlurahmanf.starter_app_mvp.R
import com.fadlurahmanf.starter_app_mvp.base.BaseDialog
import com.fadlurahmanf.starter_app_mvp.databinding.DialogConfirmBinding


class ConfirmDialog: BaseDialog<DialogConfirmBinding>(DialogConfirmBinding::inflate) {

    private var cancelListener : () -> Unit = {dismiss()}
    private var confirmListener : () -> Unit = {dismiss()}

    companion object{
        const val TITLE = "TITLE"
        const val CONTENT = "CONTENT"
        const val IS_CANCELABLE = "IS_CANCELABLE"
        const val CANCEL_TEXT = "CANCEL_TEXT"
        const val CONFIRM_TEXT = "CONIFRM_TEXT"
    }

    override fun setup() {
        initData()
        binding?.btnCancel?.setOnClickListener {
            cancelListener()
        }

        binding?.btnConfirm?.setOnClickListener {
            confirmListener()
        }
    }

    private fun initData() {
        val title: String?
        val content:String?
        val isCancelable:Boolean?
        val cancelText:String?
        val confirmText:String?

        val bundle = this.arguments

        title = bundle?.getString(TITLE, null)
        content = bundle?.getString(CONTENT, null)
        isCancelable = bundle?.getBoolean(IS_CANCELABLE, true)
        cancelText = bundle?.getString(CANCEL_TEXT, "CANCEL")
        confirmText = bundle?.getString(CONFIRM_TEXT, "CONFIRM")

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

        binding?.btnCancel?.text = cancelText
        binding?.btnConfirm?.text = confirmText
    }

    fun setListener(cancel:() -> Unit, confirm:()->Unit){
        this.cancelListener = cancel
        this.confirmListener = confirm
    }

    override fun injectView() {}

    override fun getTheme(): Int {
        return R.style.DialogAllRounded15
    }
}