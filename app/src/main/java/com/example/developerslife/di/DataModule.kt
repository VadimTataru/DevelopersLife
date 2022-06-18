package com.example.developerslife.di

import com.example.developerslife.data.repository.MemeRepositoryImpl
import com.example.developerslife.data.source.remote.IDevelopersLifeAPI
import com.example.developerslife.domain.repository.IMemeRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideMemeRepository(developersLifeAPI: IDevelopersLifeAPI): IMemeRepository {
        return MemeRepositoryImpl(developersLifeAPI)
    }
}