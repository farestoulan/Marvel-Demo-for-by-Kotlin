package com.example.marvel_demo.data.di

import com.example.marvel_demo.data.dataSource.local.LocalDataSource
import com.example.marvel_demo.presentation.viewModels.MarvelViewModel
import com.example.marvel_demo.data.dataSource.remote.RemoteDataSource
import com.example.marvel_demo.data.repository.Repository
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModules:Module = module {

    viewModel{ MarvelViewModel(repository = get()) }
}

val repositoryModules:Module = module {
    single { RemoteDataSource }
    single { LocalDataSource(androidApplication()) }
    single { Repository(remoteData =get() , localData = get()) }
}
