package com.example.marvel_demo.data.ModelClasses

import com.google.gson.annotations.SerializedName

class ListModelClass(
    @SerializedName("description")
    var description: String,
    @SerializedName("thumbnail")
    var thumbnail: ThumbnailModel
)