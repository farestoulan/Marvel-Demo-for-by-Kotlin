package com.example.marvel_demo.data.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class UserApp:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@UserApp)
            modules(listOf(
                viewModelModules,
                repositoryModules
            ))
        }
    }
}