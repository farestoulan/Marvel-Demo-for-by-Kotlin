package com.example.marvel_demo.data.models

import com.google.gson.annotations.SerializedName


class Results {
    @JvmField
    @SerializedName("results")
    var results: MutableList<CharacterModel>? = null
}