package com.enciyo.movieapp.presentation.trending

import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigator
import com.enciyo.movieapp.R
import com.enciyo.movieapp.data.model.TrendingEntitiy


class TrendingNavigatorImp(private val navController: NavController) : TrendingNavigator {

    override fun showDetail(trendingEntitiy: TrendingEntitiy, extas: FragmentNavigator.Extras) {
        TrendingFragmentDirections
            .actionTrendingFragmentToMovieDetailFragment(trendingEntitiy)
            .also {
                navController.navigate(it,extas)
            }
    }

    override fun showSearch() {
        navController.navigate(R.id.action_trendingFragment_to_searchFragment)
    }

}