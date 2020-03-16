package com.enciyo.movieapp.data.remote

import com.enciyo.movieapp.data.remote.model.TrendingResponseModel
import com.enciyo.movieapp.data.remote.endpoints.Endpoints
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TrendingService {


    @GET(Endpoints.TRENDING)
    fun getNetwork(
        @Path("media_type") mediaTypes: String,
        @Path("time_window") timeWindows: String
    ): Single<TrendingResponseModel>


}