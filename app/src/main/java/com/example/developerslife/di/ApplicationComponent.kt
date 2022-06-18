package com.example.developerslife.di

import com.example.developerslife.presentation.fragments.mainscreen.MainScreenFragment
import com.example.developerslife.presentation.fragments.mainscreen.MainScreenViewModel
import dagger.Component

@Component(modules = [DomainModule::class, DataModule::class, NetworkModule::class, AppModule::class])
interface ApplicationComponent {
    fun inject(mainScreenViewModel: MainScreenViewModel)
}