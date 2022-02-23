package com.fadlurahmanf.starter_app_mvp.ui.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fadlurahmanf.starter_app_mvp.BaseApp
import com.fadlurahmanf.starter_app_mvp.R
import com.fadlurahmanf.starter_app_mvp.base.BaseActivity
import com.fadlurahmanf.starter_app_mvp.data.repository.example.ExampleRepository
import com.fadlurahmanf.starter_app_mvp.databinding.ActivityFragmentBinding
import com.fadlurahmanf.starter_app_mvp.di.component.ExampleComponent
import javax.inject.Inject

class FragmentActivity : BaseActivity<ActivityFragmentBinding>(ActivityFragmentBinding::inflate) {
    lateinit var component:ExampleComponent

    override fun injectView() {
        component = (applicationContext as BaseApp).appComponent.exampleComponent().create()
        component.inject(this)
    }

    @Inject
    lateinit var exampleRepository: ExampleRepository

    override fun setup() {

        var firstFragment = FirstFragment()
        var secondFragment = SecondFragment()

        var fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl1, firstFragment)
        fragmentTransaction.replace(R.id.fl2, secondFragment)
        fragmentTransaction.commit()
    }

}