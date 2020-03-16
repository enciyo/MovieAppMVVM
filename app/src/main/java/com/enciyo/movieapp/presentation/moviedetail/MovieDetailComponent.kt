package com.enciyo.movieapp.presentation.moviedetail

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module


object MovieDetailComponent {

    fun inject() = movieModule

    private val movieModule by lazy {
        loadKoinModules(module {
            factory { provideMovieDetailBindingComponent() }
            viewModel { provideMovieDetailFragmentViewModel() }
            factory { provideMovieDetailNavigator() }
        })
    }


    private fun provideMovieDetailBindingComponent() = MovieDetailBindingComponentImp() as MovieDetailBindingComponent
    private fun provideMovieDetailFragmentViewModel() = MovieDetailFragmentViewModel()
    private fun provideMovieDetailNavigator() = MovieDetailNavigatorImp() as MovieDetailNavigator

}

