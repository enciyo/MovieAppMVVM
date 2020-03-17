package com.enciyo.movieapp.presentation.search

import com.enciyo.movieapp.data.model.TrendingEntitiy


interface SearchFragmentNavigator {

    fun showDetail(trendingEntitiy: TrendingEntitiy)

}