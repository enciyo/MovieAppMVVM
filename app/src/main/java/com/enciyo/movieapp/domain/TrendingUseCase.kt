package com.enciyo.movieapp.domain

import com.enciyo.movieapp.common.resource.Resource
import com.enciyo.movieapp.data.model.TrendingEntitiy
import io.reactivex.Observable

interface TrendingUseCase {
    fun fetchAllMoviesDay(): Observable<Resource<List<TrendingEntitiy>>>
}