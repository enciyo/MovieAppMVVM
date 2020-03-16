package com.enciyo.movieapp.data.datasource

import com.enciyo.movieapp.data.mapper.TrendingEntitiyMapper
import com.enciyo.movieapp.data.model.TrendingEntitiy
import com.enciyo.movieapp.data.remote.TrendingService
import com.enciyo.movieapp.data.remote.model.MediaTypes
import com.enciyo.movieapp.data.remote.model.TimeWindows
import com.enciyo.movieapp.data.remote.model.TrendingResultModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers


class TrendingRemoteDataSourceImp(
    private val mTrendingService: TrendingService,
    private val mTrendingEntitiyMapper: TrendingEntitiyMapper<TrendingResultModel, TrendingEntitiy>
) : TrendingRemoteDataSource {


    override fun fetchMovies(mediaTypes: MediaTypes, timeWindows: TimeWindows): Single<List<TrendingEntitiy>?> {
        return mTrendingService
            .getNetwork(mediaTypes = mediaTypes.path, timeWindows = timeWindows.path)
            .map { it.mTrendingResultModels?.map { mTrendingEntitiyMapper.mapFrom(it, timeWindows) } }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
    }

}