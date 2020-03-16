package com.enciyo.movieapp.data.remote.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class TrendingResponseModel(
    @SerializedName("results")
    val mTrendingResultModels: List<TrendingResultModel>? = null
) : Serializable