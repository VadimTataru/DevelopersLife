package com.example.developerslife.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.developerslife.R
import com.example.developerslife.databinding.ActivityMainBinding
import com.example.developerslife.presentation.fragments.MainScreenFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.flContainer,
                MainScreenFragment()
            )
            .commit()
    }
}