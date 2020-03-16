package com.enciyo.movieapp.presentation.trending

import com.enciyo.movieapp.data.model.TrendingEntitiy


interface TrendingNavigator {
    fun showDetail(trendingEntitiy: TrendingEntitiy)
}