package com.example.developerslife.data.source.remote

import com.example.developerslife.data.models.MemeModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface IDevelopersLifeAPI {
    @GET("./random?json=true")
    @Headers("Content-Type: application/json")
    fun getMeme(): Single<MemeModel>

    @GET("api")
    fun getAnswer(): Single<MemeModel>
}