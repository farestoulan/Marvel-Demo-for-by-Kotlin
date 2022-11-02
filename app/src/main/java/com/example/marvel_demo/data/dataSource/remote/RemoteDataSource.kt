package com.example.marvel_demo.data.dataSource.remote

import com.example.marvel_demo.data.models.CharactersEndPoint
import com.example.marvel_demo.data.models.DataModelClass
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val charactersEndPoint: CharactersEndPoint
)  {

    suspend fun getCharacters(): Response<DataModelClass> {
        return charactersEndPoint.getCharactersPhoto()
    }

}