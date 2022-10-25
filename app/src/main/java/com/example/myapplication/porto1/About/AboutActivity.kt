package com.example.myapplication.porto1.About

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.myapplication.porto1.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}