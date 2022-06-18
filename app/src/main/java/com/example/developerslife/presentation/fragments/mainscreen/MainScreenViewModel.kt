package com.example.developerslife.presentation.fragments.mainscreen

import androidx.lifecycle.ViewModel
import com.example.developerslife.data.models.MemeModel
import com.example.developerslife.domain.usecase.GetMemeUseCase
import io.reactivex.Single
import javax.inject.Inject

open class MainScreenViewModel(
    private val getMemeUseCase: GetMemeUseCase
): ViewModel(){

    fun getMeme(): Single<MemeModel> {
        return getMemeUseCase.execute()
    }
}