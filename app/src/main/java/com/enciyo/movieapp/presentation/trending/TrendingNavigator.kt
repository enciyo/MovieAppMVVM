package com.enciyo.movieapp.presentation.trending

import androidx.navigation.fragment.FragmentNavigator
import com.enciyo.movieapp.data.model.TrendingEntitiy


interface TrendingNavigator {
    fun showDetail(trendingEntitiy: TrendingEntitiy, extas: FragmentNavigator.Extras)
    fun showSearch()
}