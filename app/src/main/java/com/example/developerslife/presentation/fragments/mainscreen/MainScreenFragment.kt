package com.example.developerslife.presentation.fragments.mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.developerslife.data.source.remote.IDevelopersLifeAPI
import com.example.developerslife.databinding.FragmentMainScreenBinding
import com.example.developerslife.utils.Constants.BASE_URL
import retrofit2.Retrofit

class MainScreenFragment : Fragment() {
    lateinit var binding: FragmentMainScreenBinding
    private var service: IDevelopersLifeAPI? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(inflater)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()

        service = retrofit.create(IDevelopersLifeAPI::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
        }
    }
}