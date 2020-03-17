package com.enciyo.movieapp.di

import com.enciyo.movieapp.domain.repository.TrendingRepository
import com.enciyo.movieapp.data.TrendingRepositoryImp
import com.enciyo.movieapp.data.datasource.TrendingLocalDataSource
import com.enciyo.movieapp.data.datasource.TrendingRemoteDataSource
import org.koin.dsl.module


object RepositoryModule {

    fun newInstance() = module {
        single {
            provideTrendingRepository(trendingLocalDataSource = get(), trendingRemoteDataSource = get())
        }
    }


    private fun provideTrendingRepository(
        trendingLocalDataSource: TrendingLocalDataSource,
        trendingRemoteDataSource: TrendingRemoteDataSource

    ): TrendingRepository = TrendingRepositoryImp(
        trendingLocalDataSource,
        trendingRemoteDataSource
    )

}