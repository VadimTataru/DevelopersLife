package com.example.developerslife.presentation.fragments.mainscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
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
    private val compositeDisposable = CompositeDisposable()
    //@Inject
    //lateinit var useCase: GetMemeUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //(applicationContext as App).appComponent.inject(this@MainScreenFragment)
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
        //loadMeme()
        binding.btnNext.setOnClickListener {
            loadMeme()
        }
    }

    private fun loadMeme() {
        compositeDisposable.add(mainScreenViewModel.getMeme()
            .subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                glideIt(it.gifUrl)
                binding.tvDescription.text = it.description
            }, {
                Log.d(LOG_TAG, "Error: ${it.message}")
            }))
    }

    private fun glideIt(link: String?) {
        Glide
            .with(this)
            .load(link)
            .centerCrop()
            .into(binding.gifPlaceholder)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}