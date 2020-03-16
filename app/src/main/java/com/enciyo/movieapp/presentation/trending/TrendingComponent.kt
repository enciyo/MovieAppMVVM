package com.enciyo.movieapp.presentation.trending

import com.enciyo.movieapp.common.navigator.Navigator
import com.enciyo.movieapp.domain.TrendingUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module


object TrendingComponent {

    fun inject() = mAdapterModule

    private val mAdapterModule by lazy {
        loadKoinModules(module {
            single { provideTrendingBindingComponents() }
            factory { provideTrendingNavigator(navigator = get()) }
            factory { provideTrendingAdapter() }
            viewModel { provideTrendingViewModel(trendingUseCase = get(), trendingNavigator = get()) }

        })
    }


    private fun provideTrendingBindingComponents() = TrendingBindingComponentImp() as TrendingBindingComponent

    private fun provideTrendingNavigator(navigator: Navigator) = navigator.provideTrendingNavigator()

    private fun provideTrendingAdapter() = TrendingAdapter()

    private fun provideTrendingViewModel(trendingUseCase: TrendingUseCase, trendingNavigator: TrendingNavigator) =
        TrendingFragmentViewModel(trendingUseCase, trendingNavigator)


}

