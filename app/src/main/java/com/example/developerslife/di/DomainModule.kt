package com.example.developerslife.di

import com.example.developerslife.domain.repository.IMemeRepository
import com.example.developerslife.domain.usecase.GetMemeUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideGetMemeUseCase(memeRepository: IMemeRepository): GetMemeUseCase {
        return GetMemeUseCase(memeRepository)
    }
}