package com.enciyo.movieapp.di

import com.enciyo.movieapp.presentation.MainActivityViewModel
import com.enciyo.movieapp.presentation.main.MainFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


object ViewModelModule {
    fun newInstance() = module {
        viewModel { provideActivityViewModel() }
        viewModel { provideMainFragmentViewModel() }
    }

    private fun provideActivityViewModel() = MainActivityViewModel()
    private fun provideMainFragmentViewModel() = MainFragmentViewModel()

}