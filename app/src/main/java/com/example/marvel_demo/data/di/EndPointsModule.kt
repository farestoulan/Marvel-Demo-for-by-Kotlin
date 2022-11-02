package com.example.marvel_demo.data.di

import com.example.marvel_demo.data.models.CharactersEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EndPointsModule {

    @Provides
    @Singleton
    fun provideCharactersEndPoints(retrofit: Retrofit): CharactersEndPoint =
        retrofit.create(CharactersEndPoint::class.java)


}