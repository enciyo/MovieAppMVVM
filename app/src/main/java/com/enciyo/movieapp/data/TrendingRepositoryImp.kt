package com.enciyo.movieapp.data

import android.accounts.NetworkErrorException
import android.util.Log
import com.enciyo.movieapp.common.resource.Resource
import com.enciyo.movieapp.data.datasource.TrendingLocalDataSource
import com.enciyo.movieapp.data.datasource.TrendingRemoteDataSource
import com.enciyo.movieapp.data.model.TrendingEntitiy
import com.enciyo.movieapp.data.remote.model.MediaTypes
import com.enciyo.movieapp.data.remote.model.TimeWindows
import com.enciyo.movieapp.domain.repository.TrendingRepository
import io.reactivex.Observable


class TrendingRepositoryImp(
    private val mTrendingLocalDataSource: TrendingLocalDataSource,
    private val mTrendingRemoteDataSource: TrendingRemoteDataSource
) : TrendingRepository {

    override fun getAllMoviesDay(mediaTypes: MediaTypes, timeWindows: TimeWindows): Observable<Resource<List<TrendingEntitiy>>> {
        return Observable.create { emitter ->
            emitter.onNext(Resource.Loading())
            mTrendingRemoteDataSource.fetchMovies(mediaTypes, timeWindows).subscribe(
                {
                    it?.let(::saveTrendingMovies)
                }, {
                    emitter.onNext(Resource.Failure(NetworkErrorException()))
                })
            mTrendingLocalDataSource.getMovies(mediaTypes, timeWindows).subscribe(
                {
                    emitter.onNext(Resource.Success(it))
                }, {
                    Log.i("MyLogger", it.message.toString())
                })
        }
    }

    private fun saveTrendingMovies(list: List<TrendingEntitiy>) {
        mTrendingLocalDataSource.saveTrendingMovies(list).subscribe()
    }


}