package com.example.marvel_demo.data.dataSource.local.Database

import com.example.marvel_demo.data.models.DataModelClass
import androidx.room.*
import androidx.room.Dao

@Dao
interface DAOClass {

    @Insert
    fun insertAllData(dataModelClass: DataModelClass?)

    @Query("select * from Marvel")
    fun getAllData(): DataModelClass?
}