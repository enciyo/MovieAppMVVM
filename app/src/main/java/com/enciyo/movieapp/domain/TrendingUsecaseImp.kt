package com.enciyo.movieapp.domain

import com.enciyo.movieapp.common.resource.Resource
import com.enciyo.movieapp.data.model.TrendingEntitiy
import com.enciyo.movieapp.data.remote.model.MediaTypes
import com.enciyo.movieapp.data.remote.model.TimeWindows
import com.enciyo.movieapp.domain.repository.TrendingRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


class TrendingUsecaseImp(
    private val mTrendingRepository: TrendingRepository
) : TrendingUseCase {

    override fun fetchAllMoviesDay(): Observable<Resource<List<TrendingEntitiy>>> {
        return mTrendingRepository
            .getAllMoviesDay(MediaTypes.All, TimeWindows.Day)
            .subscribeOn(Schedulers.io())
    }


}