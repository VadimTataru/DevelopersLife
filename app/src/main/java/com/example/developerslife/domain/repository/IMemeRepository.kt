package com.example.developerslife.domain.repository

import com.example.developerslife.data.models.MemeModel
import io.reactivex.Single

interface IMemeRepository {
    fun getMeme(): Single<MemeModel>
}