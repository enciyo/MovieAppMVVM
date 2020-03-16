package com.enciyo.movieapp.di

import com.enciyo.movieapp.domain.repository.TrendingRepository
import com.enciyo.movieapp.domain.TrendingUseCase
import com.enciyo.movieapp.domain.TrendingUsecaseImp
import org.koin.dsl.module


object UsecaseModule {

    fun newInstance() = module {
        factory { provideTrendingUsecase(mTrendingRepository = get()) }
    }

    private fun provideTrendingUsecase(mTrendingRepository: TrendingRepository) =
        TrendingUsecaseImp(mTrendingRepository) as TrendingUseCase

}