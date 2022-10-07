package com.example.developerslife.presentation.fragments.mainscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.developerslife.app.App
import com.example.developerslife.databinding.FragmentMainScreenBinding
import com.example.developerslife.utils.Constants.LOG_TAG
import javax.inject.Inject

class MainScreenFragment : Fragment() {
    @Inject
    lateinit var mainScreenViewModel: MainScreenViewModel
    private lateinit var binding: FragmentMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (this.activity?.applicationContext as App).appComponent.inject(this@MainScreenFragment)
        Log.d(LOG_TAG, "fragment onCreate");
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainScreenViewModel.fetchMeme()
        binding.btnNext.setOnClickListener {
            mainScreenViewModel.getNextMeme()
        }
        binding.btnBack.setOnClickListener {
            mainScreenViewModel.getPreviousMeme()
        }

        mainScreenViewModel.getDescriptionLive().observe(viewLifecycleOwner) { text ->
            binding.tvDescription.text = text
        }
        mainScreenViewModel.getLinkLive().observe(viewLifecycleOwner) {
            glideIt(it)
        }
        mainScreenViewModel.getBackBtnState().observe(viewLifecycleOwner) {
            binding.btnBack.isEnabled = it
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        Glide.get(requireContext()).clearDiskCache()
    }

    private fun glideIt(link: String?) {
        Glide
            .with(this)
            .load(link)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.gifPlaceholder)
    }
}