package com.enciyo.movieapp.common.navigator

import androidx.navigation.NavController
import com.enciyo.movieapp.common.navigator.Navigator
import com.enciyo.movieapp.presentation.trending.TrendingNavigator
import com.enciyo.movieapp.presentation.trending.TrendingNavigatorImp


class NavigatorImp (private val navController: NavController) : Navigator {

    override fun provideTrendingNavigator() = TrendingNavigatorImp(navController) as TrendingNavigator

}