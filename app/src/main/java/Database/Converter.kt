package Database

import ModelClasses.ListModelClass
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun fromString(value: String?): List<ListModelClass?>? {
        val listType = object : TypeToken<List<ListModelClass?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<ListModelClass?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}