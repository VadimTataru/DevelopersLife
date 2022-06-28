package com.example.developerslife.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.developerslife.R
import com.example.developerslife.databinding.ActivityMainBinding
import com.example.developerslife.presentation.fragments.mainscreen.MainScreenFragment

class MainActivity : FragmentActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //initNavController()

        /*supportFragmentManager.beginTransaction()
            .replace(
                R.id.flContainer,
                MainScreenFragment()
            )
            .commit()*/
    }

    private fun initNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController
    }
}