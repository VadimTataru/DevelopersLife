package com.example.developerslife.data.repository

import com.example.developerslife.data.models.MemeModel
import com.example.developerslife.data.source.remote.IDevelopersLifeAPI
import com.example.developerslife.domain.repository.IMemeRepository
import io.reactivex.Single

class MemeRepositoryImpl(
    private val developersLife: IDevelopersLifeAPI
): IMemeRepository {
    override fun getMeme(): Single<MemeModel> {
        val data = developersLife.getMeme()
        return data
    }
}