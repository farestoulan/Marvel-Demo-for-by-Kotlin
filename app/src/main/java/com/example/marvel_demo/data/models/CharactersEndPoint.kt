package com.example.marvel_demo.data.models

import retrofit2.Response
import retrofit2.http.GET

interface CharactersEndPoint {

   @GET("/v1/public/characters?limit=20&ts=1&apikey=c78f40bb1c616599c702d91d22e35aea&hash=a7dec653688d4d0a0893ed07021ceaac")
   suspend fun getCharactersPhoto(): Response<DataModelClass>

}