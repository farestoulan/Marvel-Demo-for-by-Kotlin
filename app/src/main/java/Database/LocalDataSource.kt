package Database

import ModelClasses.DataModelClass
import android.content.Context

class LocalDataSource(context: Context) {
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