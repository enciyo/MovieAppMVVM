package com.enciyo.movieapp.data.datasource

import com.enciyo.movieapp.data.model.TrendingEntitiy
import com.enciyo.movieapp.data.remote.model.MediaTypes
import com.enciyo.movieapp.data.remote.model.TimeWindows
import io.reactivex.Single


interface TrendingRemoteDataSource {
    fun fetchMovies(mediaTypes: MediaTypes, timeWindows: TimeWindows): Single<List<TrendingEntitiy>?>
}