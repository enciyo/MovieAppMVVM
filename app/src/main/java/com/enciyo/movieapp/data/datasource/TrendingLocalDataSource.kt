package com.enciyo.movieapp.data.datasource

import com.enciyo.movieapp.data.model.TrendingEntitiy
import com.enciyo.movieapp.data.remote.model.MediaTypes
import com.enciyo.movieapp.data.remote.model.TimeWindows
import io.reactivex.Flowable
import io.reactivex.Single


interface TrendingLocalDataSource {
    fun getMovies(mediaTypes: MediaTypes, timeWindows: TimeWindows): Flowable<List<TrendingEntitiy>>
    fun saveTrendingMovies(trendingEntities: List<TrendingEntitiy>): Single<Unit>
}