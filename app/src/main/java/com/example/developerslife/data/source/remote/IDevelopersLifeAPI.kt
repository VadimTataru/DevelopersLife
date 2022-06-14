package com.example.developerslife.data.source.remote

import com.example.developerslife.data.models.MemeModel
import io.reactivex.Single
import retrofit2.http.GET

interface IDevelopersLifeAPI {
    @GET("random?json=true")
    fun getMeme(): Single<MemeModel>
}