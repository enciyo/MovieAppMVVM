package com.enciyo.movieapp.di

import com.enciyo.movieapp.data.mapper.TrendingEntitiyMapperImp
import com.enciyo.movieapp.data.mapper.TrendingEntitiyMapper
import com.enciyo.movieapp.data.model.TrendingEntitiy
import com.enciyo.movieapp.data.remote.model.TrendingResultModel
import org.koin.dsl.module



object MapperModule {

    fun newInstance() = module {
        factory { provideTrendingMapper() }
    }


    private fun provideTrendingMapper(): TrendingEntitiyMapper<TrendingResultModel, TrendingEntitiy> = TrendingEntitiyMapperImp()

}