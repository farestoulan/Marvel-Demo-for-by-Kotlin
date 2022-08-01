package Database

import ModelClasses.DataModelClass
import android.content.Context

class LocalDataSource(context: Context) {
    var dao: DAOClass?
    var database: DatabaseClass?
    val localData: DataModelClass?
        get() = dao?.getAllData()

    fun insertLocalData(dataModelClass: DataModelClass?) {
        dao!!.insertAllData(dataModelClass)
    }

    init {
        database = DatabaseClass.getDatabase(context)
        dao = database?.getDao()
    }
}