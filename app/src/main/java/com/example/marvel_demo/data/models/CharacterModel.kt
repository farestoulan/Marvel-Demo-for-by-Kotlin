package com.example.marvel_demo.data.models

import com.google.gson.annotations.SerializedName

class CharacterModel(
    @SerializedName("description")
    var description: String,
    @SerializedName("thumbnail")
    var thumbnail: ThumbnailModel
)