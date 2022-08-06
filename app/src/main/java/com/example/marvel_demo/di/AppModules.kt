package com.example.marvel_demo.di

import Database.LocalDataSource
import Database.MarvelViewModel
import Database.RemoteDataSource
import Database.Repository
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModules:Module = module {

    viewModel{MarvelViewModel(repository = get())}
}

val repositoryModules:Module = module {
    single { RemoteDataSource }
    single { LocalDataSource(androidApplication()) }
    single { Repository(remoteData =get() , localData = get()) }
}
