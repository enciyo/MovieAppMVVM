package com.enciyo.movieapp

import android.app.Application
import com.enciyo.movieapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class MovieApp : Application() {


    private val moduleList by lazy {
        listOf(
            NetworkModule.newInstance(),
            MapperModule.newInstance(),
            DataSourceModule.newInstance(),
            RepositoryModule.newInstance(),
            UsecaseModule.newInstance(),
            ViewModelModule.newInstance()
        )
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@MovieApp)
            modules(moduleList)
        }
    }

}