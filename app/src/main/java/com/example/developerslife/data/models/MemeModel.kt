package com.example.developerslife.data.models

import com.google.gson.annotations.SerializedName

class MemeModel(
    @SerializedName("description")
    val description: String,
    @SerializedName("gifURL")
    val gifUrl: String
)