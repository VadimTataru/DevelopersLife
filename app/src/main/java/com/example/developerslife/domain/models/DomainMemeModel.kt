package com.example.developerslife.domain.models

import com.google.gson.annotations.SerializedName

class DomainMemeModel (
    @SerializedName("description")
    val description: String,
    @SerializedName("gifURL")
    val gifUrl: String
)