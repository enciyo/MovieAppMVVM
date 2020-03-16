package com.enciyo.movieapp.di

import androidx.navigation.NavController
import com.enciyo.movieapp.common.navigator.Navigator
import com.enciyo.movieapp.common.navigator.NavigatorImp
import org.koin.dsl.module


object NavigatorModule {

    fun newInstance(navController: NavController) = module {
        factory { provideNavigator(navController = navController) }
    }


    private fun provideNavigator(navController: NavController) = NavigatorImp(navController) as Navigator

}