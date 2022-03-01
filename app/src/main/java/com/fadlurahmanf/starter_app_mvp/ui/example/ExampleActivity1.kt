package com.fadlurahmanf.starter_app_mvp.ui.example

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.core.app.NotificationCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.fadlurahmanf.starter_app_mvp.BaseApp
import com.fadlurahmanf.starter_app_mvp.MainActivity
import com.fadlurahmanf.starter_app_mvp.base.BaseMvpActivity
import com.fadlurahmanf.starter_app_mvp.core.services.ExampleRxWorker
import com.fadlurahmanf.starter_app_mvp.core.services.ExampleWorkManager
import com.fadlurahmanf.starter_app_mvp.core.utils.NotificationUtils
import com.fadlurahmanf.starter_app_mvp.data.model.core.NotificationData
import com.fadlurahmanf.starter_app_mvp.data.repository.example.ExampleRepository
import com.fadlurahmanf.starter_app_mvp.data.response.example.BaseResponse
import com.fadlurahmanf.starter_app_mvp.databinding.ActivityExample1Binding
import com.fadlurahmanf.starter_app_mvp.di.component.ExampleComponent
import com.google.gson.Gson
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
    lateinit var notificationUtils: NotificationUtils

    @Inject
    lateinit var exampleRepository: ExampleRepository

    private lateinit var uuidObserve: UUID
    override fun setup() {
        binding?.button1?.setOnClickListener {
            presenter.getAllPost()
        }
        binding?.button2?.setOnClickListener {
            var constraint = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            var oneTimeWorkRequest = OneTimeWorkRequest.Builder(ExampleWorkManager::class.java)
                .setConstraints(constraint)
                .build()

            WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)
            uuidObserve = oneTimeWorkRequest.id
            observeWork(oneTimeWorkRequest.id)
        }

        binding?.button3?.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            var pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
            notificationUtils.showNotification(
                NotificationData(
                    "CHANNEL_ID",
                    Random().nextInt(100),
                    pendingIntent,
                    content = "HALO CONTENT HALO CONTENT HALO CONTENT HALO CONTENT HALO CONTENT ",
                    title = "HALO TITLE",
                    priority = NotificationCompat.PRIORITY_MAX
                )
            )
        }

        binding?.button4?.setOnClickListener {
            var constraint = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            var oneTimeWorkRequest = OneTimeWorkRequest.Builder(ExampleRxWorker::class.java)
                .setConstraints(constraint)
                .build()

            WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)
            uuidObserve = oneTimeWorkRequest.id
            observeWork(uuidObserve)
        }

        binding?.button5?.setOnClickListener {
            WorkManager.getInstance(this).cancelWorkById(uuidObserve)
        }

        binding?.button6?.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }

        binding?.button7?.setOnClickListener {
            showOkDialog(
                title = "EXAMPLE TITLE",
                content = "Example Content",
                isCancelable = false,
                okListener = {
                    dismissOkDialog()
                }
            )
        }
    }

    private fun observeWork(uuid: UUID){
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(uuid).observe(this, {
            if (it.outputData.getString("MESSAGE") != null){
                var response = Gson().fromJson(it.outputData.getString("MESSAGE"), BaseResponse::class.java)
                println("MASUK ${response.message}")
            }
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