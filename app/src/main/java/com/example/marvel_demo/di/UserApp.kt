package com.example.marvel_demo.di

import android.app.Application
import com.example.marvel_demo.di.repositoryModules
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