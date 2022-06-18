package com.example.developerslife.di

import com.example.developerslife.domain.usecase.GetMemeUseCase
import com.example.developerslife.presentation.fragments.mainscreen.MainScreenViewModel
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideMainScreenViewModel(getMemeUseCase: GetMemeUseCase): MainScreenViewModel {
        return MainScreenViewModel(getMemeUseCase)
    }
}