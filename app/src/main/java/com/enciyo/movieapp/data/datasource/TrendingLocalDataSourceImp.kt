package com.enciyo.movieapp.data.datasource

import com.enciyo.movieapp.data.local.TrendingDao
import com.enciyo.movieapp.data.model.TrendingEntitiy
import com.enciyo.movieapp.data.remote.model.MediaTypes
import com.enciyo.movieapp.data.remote.model.TimeWindows
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers


class TrendingLocalDataSourceImp(
    private val mTrendingDao: TrendingDao
) : TrendingLocalDataSource {


    override fun getMovies(mediaTypes: MediaTypes, timeWindows: TimeWindows): Flowable<List<TrendingEntitiy>> {
        return when (mediaTypes) {
            MediaTypes.All -> mTrendingDao.findMovie(timeWindows.path)
                .subscribeOn(Schedulers.io())
            else -> mTrendingDao.findMovie(mediaTypes.path, timeWindows.path)
                .subscribeOn(Schedulers.io())
        }
    }


    override fun saveTrendingMovies(trendingEntities: List<TrendingEntitiy>): Single<Unit> {
        return Single.just(mTrendingDao
            .saveTrendingMovies(trendingEntities))
    }


}