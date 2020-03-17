package com.enciyo.movieapp.presentation.search

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.createGraph
import androidx.navigation.ui.NavigationUI
import com.enciyo.movieapp.R
import com.enciyo.movieapp.data.model.TrendingEntitiy
import kotlinx.android.synthetic.main.main_fragment.view.*


class SearchFragmentNavigatorImp(private val mNavController: NavController) : SearchFragmentNavigator{
    override fun showDetail(trendingEntitiy: TrendingEntitiy) {

    }
}