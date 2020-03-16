package com.enciyo.movieapp.presentation.trending

import androidx.navigation.NavController
import com.enciyo.movieapp.R
import com.enciyo.movieapp.data.model.TrendingEntitiy


class TrendingNavigatorImp(private val navController: NavController) : TrendingNavigator{

    override fun showDetail(trendingEntitiy: TrendingEntitiy) {
        TrendingFragmentDirections
            .actionTrendingFragmentToMovieDetailFragment(trendingEntitiy)
            .also(navController::navigate)
    }

}