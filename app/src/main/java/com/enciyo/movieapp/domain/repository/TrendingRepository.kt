package com.enciyo.movieapp.domain.repository

import com.enciyo.movieapp.common.resource.Resource
import com.enciyo.movieapp.data.model.TrendingEntitiy
import com.enciyo.movieapp.data.remote.model.MediaTypes
import com.enciyo.movieapp.data.remote.model.TimeWindows
import io.reactivex.Observable


interface TrendingRepository {
    fun getAllMoviesDay(mediaTypes: MediaTypes, timeWindows: TimeWindows): Observable<Resource<List<TrendingEntitiy>>>
}