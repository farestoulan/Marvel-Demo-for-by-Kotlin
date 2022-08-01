package Database

import ModelClasses.DataModelClass
import androidx.room.*
import androidx.room.Dao

@Dao
interface DAOClass {

    @Insert
    fun insertAllData(dataModelClass: DataModelClass?)

    @Query("select * from Marvel")
    fun getAllData(): DataModelClass?
}