package com.example.marvel_demo.data.models


import androidx.room.PrimaryKey
import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName = "Marvel")
class DataModelClass {
    @JvmField
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @JvmField
    @Embedded
    var data: Results? = null
}