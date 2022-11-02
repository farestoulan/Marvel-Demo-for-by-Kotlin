package com.example.marvel_demo.data.di

import android.content.Context
import com.example.marvel_demo.data.dataSource.local.LocalDataSource
import com.example.marvel_demo.data.dataSource.remote.RemoteDataSource
import com.example.marvel_demo.data.models.CharactersEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourcesModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(@ApplicationContext context: Context): LocalDataSource{
        return LocalDataSource(context)
    }


    @Provides
    @Singleton
    fun provideRemoteDataSource(CharactersEndPoint: CharactersEndPoint):RemoteDataSource{
        return RemoteDataSource(CharactersEndPoint)
    }



}