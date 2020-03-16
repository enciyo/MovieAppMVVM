package com.enciyo.movieapp.common.navigator

import com.enciyo.movieapp.presentation.trending.TrendingNavigator


interface Navigator {

    fun provideTrendingNavigator(): TrendingNavigator

}