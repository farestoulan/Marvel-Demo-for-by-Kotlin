package com.example.marvel_demo.data.repository


import androidx.lifecycle.MutableLiveData
import com.example.marvel_demo.data.dataSource.local.LocalDataSource
import com.example.marvel_demo.data.dataSource.remote.RemoteDataSource
import com.example.marvel_demo.data.models.DataModelClass
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteData: RemoteDataSource,
    private val localData: LocalDataSource,
) {

    suspend fun getData(): MutableLiveData<DataModelClass?> {
        val res = MutableLiveData<DataModelClass?>()


        if (localData.getLocalData() != null) {
            res.postValue(localData.getLocalData())
        } else {

            val charactersResponse = remoteData.getCharacters()

            if (charactersResponse.isSuccessful) {
                if (charactersResponse.body() != null) {
                    val characters = charactersResponse.body()

                    localData.insertLocalData(characters!!)
                    res.postValue(characters)
                }
            } else {
                res.postValue(null)
            }
        }

        return res
    }
}