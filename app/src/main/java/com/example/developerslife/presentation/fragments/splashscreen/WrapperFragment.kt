package com.example.developerslife.presentation.fragments.splashscreen

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.developerslife.R
import com.example.developerslife.databinding.FragmentWrapperBinding
import com.example.developerslife.utils.Constants

class WrapperFragment : Fragment() {
    private lateinit var binding: FragmentWrapperBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWrapperBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMainFragment()
    }

    private fun getMainFragment() {
        Handler().postDelayed({
            findNavController().navigate(R.id.mainScreenFragment)
        }, Constants.WRAPPER_DELAY_TIME.toLong())

    }
}