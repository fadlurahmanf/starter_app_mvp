package com.fadlurahmanf.starter_app_mvp.ui.example


import android.widget.Toast
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.fadlurahmanf.starter_app_mvp.BaseApp
import com.fadlurahmanf.starter_app_mvp.base.BaseMvpActivity
import com.fadlurahmanf.starter_app_mvp.core.services.ExampleWorkManager
import com.fadlurahmanf.starter_app_mvp.data.repository.example.ExampleRepository
import com.fadlurahmanf.starter_app_mvp.databinding.ActivityExample1Binding
import com.fadlurahmanf.starter_app_mvp.di.component.ExampleComponent
import java.util.*
import javax.inject.Inject

class ExampleActivity1 : BaseMvpActivity<ExampleActivity1Presenter, ActivityExample1Binding>(ActivityExample1Binding::inflate), ExampleActivity1Contract.View {
    lateinit var exampleComponent:ExampleComponent

    override fun initPresenterView() {
        presenter.view = this
    }

    override fun injectView() {
        exampleComponent = (applicationContext as BaseApp).appComponent.exampleComponent().create()
        exampleComponent.inject(this)
    }

    @Inject
    lateinit var exampleRepository: ExampleRepository

    override fun setup() {
        binding?.button1?.setOnClickListener {
            presenter.getAllPost()
        }
        binding?.button2?.setOnClickListener {
            var oneTimeWorkRequest = OneTimeWorkRequest.Builder(ExampleWorkManager::class.java).build()
            WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)
            observeWork(oneTimeWorkRequest.id)
        }
    }

    private fun observeWork(uuid: UUID){
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(uuid).observe(this, {
            println("MASUK ${it}")
        })
    }

    @Inject
    lateinit var presenter: ExampleActivity1Presenter

    override fun exampleViewSuccess() {
        Toast.makeText(this, "Example Success", Toast.LENGTH_LONG).show()
    }

    override fun exampleViewError(message: String?) {
        Toast.makeText(this, "Example Error : $message", Toast.LENGTH_LONG).show()
    }

}