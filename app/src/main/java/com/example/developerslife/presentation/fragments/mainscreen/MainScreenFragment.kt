package com.example.developerslife.presentation.fragments.mainscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.developerslife.app.App
import com.example.developerslife.databinding.FragmentMainScreenBinding
import com.example.developerslife.domain.usecase.GetMemeUseCase
import com.example.developerslife.utils.Constants.LOG_TAG
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainScreenFragment : Fragment() {
    @Inject
    lateinit var mainScreenViewModel: MainScreenViewModel
    lateinit var binding: FragmentMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (this.activity?.applicationContext as App).appComponent.inject(this@MainScreenFragment)
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

        //mainScreenViewModel.fetchMeme()
        binding.btnNext.setOnClickListener {
            //use getNextMeme() to get next meme
            //mainScreenViewModel.fetchMeme()
        }

        mainScreenViewModel.getDescriptionLive().observe(viewLifecycleOwner) { text ->
            binding.tvDescription.text = text
        }
        mainScreenViewModel.getLinkLive().observe(viewLifecycleOwner) {
            glideIt(it)
        }

    }

    private fun glideIt(link: String?) {
        Glide
            .with(this)
            .load(link)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.gifPlaceholder)
    }

    override fun onDestroy() {
        super.onDestroy()
        Glide.get(requireContext()).clearDiskCache()
    }
}