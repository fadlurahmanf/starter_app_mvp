package com.fadlurahmanf.starter_app_mvp.ui.example

import android.app.PendingIntent
import android.content.Intent
import android.util.Base64
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.fadlurahmanf.starter_app_mvp.BaseApp
import com.fadlurahmanf.starter_app_mvp.MainActivity
import com.fadlurahmanf.starter_app_mvp.base.BaseMvpActivity
import com.fadlurahmanf.starter_app_mvp.core.services.work.example.ExampleCoroutineWorkManager
import com.fadlurahmanf.starter_app_mvp.core.services.work.example.ExampleRxWorker
import com.fadlurahmanf.starter_app_mvp.core.utils.NotificationUtils
import com.fadlurahmanf.starter_app_mvp.data.model.core.NotificationData
import com.fadlurahmanf.starter_app_mvp.data.repository.example.ExampleRepository
import com.fadlurahmanf.starter_app_mvp.databinding.ActivityExample1Binding
import com.fadlurahmanf.starter_app_mvp.di.component.ExampleComponent
import java.nio.charset.Charset
import java.security.MessageDigest
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
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

            var oneTimeWorkRequest = OneTimeWorkRequest.Builder(ExampleCoroutineWorkManager::class.java)
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

//            var constraint = Constraints.Builder()
//                .setRequiredNetworkType(NetworkType.CONNECTED)
//                .build()
//
//            var oneTimeWorkRequest = OneTimeWorkRequest.Builder(ExampleInjectWorker::class.java)
//                .setConstraints(constraint)
//                .build()
//
//            WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)
//            uuidObserve = oneTimeWorkRequest.id
//            observeWork(uuidObserve)
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

        binding?.button8?.setOnClickListener {
            showConfirmDialog(
                title = "EXAMPLE TITLE",
                content = "EXAMPLE CONTENT",
                isCancelable = false,
                cancelListener = {
                    dismissConfirmDialog()
                },
                confirmListener = {
                    dismissConfirmDialog()
                }
            )
        }



        binding?.button9?.setOnClickListener {
            try {
                var secretKeySpec : SecretKeySpec? = generateKey("bch8SNnxia9DnxBDAddbxa124")
                var cipher = Cipher.getInstance("AES")
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec)
                var encryptedByteArray = cipher.doFinal("Rujianto".toByteArray())
                var encrypted = Base64.encodeToString(encryptedByteArray, Base64.DEFAULT)
                println("MASUK ENCRYPTED $encrypted")
//                DGPB6LQPpbU2SXvcSc/G3A== password 123456
//                73ajCvucTnpOKHw2P+6Jbg== password 654321
            }catch (e:Exception){
                println("MASUK ENCRYPT ERROR ${e.message}")
            }
        }

        binding?.button10?.setOnClickListener {
            try {
                var secretKeySpec : SecretKeySpec? = generateKey("bch8SNnxia9DnxBDAddbxa124")
                var cipher = Cipher.getInstance("AES")
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec)
                var decodeValue = Base64.decode("Dl6hDLLJd0pup0KYrxYwOQ==", Base64.DEFAULT)
                var dcdValue = cipher.doFinal(decodeValue)
                var decrypted = String(dcdValue)
                println("MASUK DECRYPTED $decrypted")
            }catch (e:Exception){
                println("MASUK DECRYPT ERROR ${e.message}")
            }
        }
    }


    private fun generateKey(password:String): SecretKeySpec? {
        try {
            var messageDigest = MessageDigest.getInstance("SHA-256")
            var bytes = password.toByteArray(Charset.forName("UTF-8"))
            messageDigest.update(bytes, 0, bytes.size)
            var key = messageDigest.digest()
            var secretKeySpec = SecretKeySpec(key, "AES")
            return secretKeySpec
        }catch (e:Exception){
            return null
        }
    }

    private fun observeWork(uuid: UUID){
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(uuid).observe(this) {
            println("MASUK ${it.progress}")
            println("MASUK ${it.outputData}")
        }
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