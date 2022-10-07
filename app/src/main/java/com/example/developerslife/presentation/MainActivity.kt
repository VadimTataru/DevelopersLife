package com.example.developerslife.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.developerslife.R
import com.example.developerslife.databinding.ActivityMainBinding
import com.example.developerslife.presentation.fragments.mainscreen.MainScreenFragment
import com.example.developerslife.utils.Constants.LOG_TAG

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(LOG_TAG, "activity onCreate")
    }
}