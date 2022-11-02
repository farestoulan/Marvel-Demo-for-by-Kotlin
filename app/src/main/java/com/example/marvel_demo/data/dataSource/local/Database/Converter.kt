package com.example.marvel_demo.data.dataSource.local.Database

import com.example.marvel_demo.data.models.CharacterModel
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun fromString(value: String?): List<CharacterModel?>? {
        val listType = object : TypeToken<List<CharacterModel?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<CharacterModel?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}