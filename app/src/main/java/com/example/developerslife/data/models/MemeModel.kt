package com.example.developerslife.data.models

import com.google.gson.annotations.SerializedName

class MemeModel(
    @SerializedName("answer")
    val description: String,
    @SerializedName("image")
    val gifUrl: String
)