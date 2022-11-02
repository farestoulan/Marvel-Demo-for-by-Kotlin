package com.example.marvel_demo.data.dataSource.local

import com.example.marvel_demo.data.models.DataModelClass
import android.content.Context
import com.example.marvel_demo.data.dataSource.local.Database.DAOClass
import com.example.marvel_demo.data.dataSource.local.Database.DatabaseClass
import javax.inject.Inject

class LocalDataSource @Inject constructor (
    context: Context) {
    var dao: DAOClass?
    var database: DatabaseClass?

    fun getLocalData(): DataModelClass? {
        return dao?.getAllData()
    }

    fun insertLocalData(dataModelClass: DataModelClass?) {
        dao!!.insertAllData(dataModelClass)
    }

    init {
        database = DatabaseClass.getDatabase(context)
        dao = database?.getDao()
    }
}