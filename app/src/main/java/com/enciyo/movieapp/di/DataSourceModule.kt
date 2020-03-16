package com.enciyo.movieapp.di

import com.enciyo.movieapp.data.remote.TrendingService
import com.enciyo.movieapp.data.datasource.TrendingLocalDataSource
import com.enciyo.movieapp.data.datasource.TrendingLocalDataSourceImp
import com.enciyo.movieapp.data.mapper.TrendingEntitiyMapper
import com.enciyo.movieapp.data.model.TrendingEntitiy
import com.enciyo.movieapp.data.local.TrendingDao
import com.enciyo.movieapp.data.datasource.TrendingRemoteDataSource
import com.enciyo.movieapp.data.datasource.TrendingRemoteDataSourceImp
import com.enciyo.movieapp.data.remote.model.TrendingResultModel
import org.koin.dsl.module


object DataSourceModule {

    fun newInstance() = module {
        factory { provideTrendingLocalDataSource(mTrendingDao = get()) }
        factory { provideTrendingRemoteDataSource(mTrendingService = get(), mTrendingEntitiyMapper = get()) }
    }


    private fun provideTrendingRemoteDataSource(mTrendingService: TrendingService, mTrendingEntitiyMapper:
    TrendingEntitiyMapper<TrendingResultModel, TrendingEntitiy>) =
        TrendingRemoteDataSourceImp(mTrendingService, mTrendingEntitiyMapper)
                as TrendingRemoteDataSource

    private fun provideTrendingLocalDataSource(mTrendingDao: TrendingDao) = TrendingLocalDataSourceImp(mTrendingDao) as
            TrendingLocalDataSource

}