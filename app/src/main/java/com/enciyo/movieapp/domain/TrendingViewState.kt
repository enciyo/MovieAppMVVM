package com.enciyo.movieapp.domain

import com.enciyo.movieapp.data.model.TrendingEntitiy


data class TrendingViewState(
    val mHeaderName: String,
    val mHeaderImage: String,
    val mIsLoading: Boolean,
    val mTrendingAdapter: List<TrendingEntitiy>? = emptyList()
)