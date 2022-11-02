package com.example.marvel_demo.data.models

import com.google.gson.annotations.SerializedName


class ThumbnailModel(
    @SerializedName("path") var path: String, @SerializedName(
        "extension"
    ) var extension: String
)