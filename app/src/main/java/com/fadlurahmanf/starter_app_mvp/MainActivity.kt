package com.fadlurahmanf.starter_app_mvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fadlurahmanf.starter_app_mvp.databinding.ActivityMainBinding
import com.fadlurahmanf.starter_app_mvp.ui.example.ExampleActivity1

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, ExampleActivity1::class.java)
        startActivity(intent)
    }
}