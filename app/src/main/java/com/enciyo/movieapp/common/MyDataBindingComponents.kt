package com.enciyo.movieapp.common

import androidx.databinding.DataBindingComponent
import com.enciyo.movieapp.presentation.moviedetail.MovieDetailBindingComponent
import com.enciyo.movieapp.presentation.trending.TrendingBindingComponent
import org.koin.core.KoinComponent
import org.koin.core.inject

class MyDataBindingComponents : DataBindingComponent, KoinComponent {

    private val mTrendingComponent: TrendingBindingComponent by inject()
    private val mMovieDetailComponent: MovieDetailBindingComponent by inject()

    override fun getMovieDetailBindingComponent(): MovieDetailBindingComponent = mMovieDetailComponent

    override fun getTrendingBindingComponent(): TrendingBindingComponent = mTrendingComponent

}