package com.enciyo.movieapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.enciyo.movieapp.R
import com.enciyo.movieapp.common.resource.Resource
import com.enciyo.movieapp.di.NavigatorModule
import com.enciyo.movieapp.domain.TrendingUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules

class MainActivity : AppCompatActivity() {

    private val mTrendingUseCase: TrendingUseCase by inject()


    private val mloadingKoinModule by lazy {
        findNavController(R.id.nav_host_graph).also(::loadNavigatorModule)
    }
    private fun injectNavigator() = mloadingKoinModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectNavigator()


        mTrendingUseCase
            .fetchAllMoviesDay()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                when (it) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        Log.i("MyLogger", it.data?.last()?.mId.toString())
                    }
                    is Resource.Failure -> {
                        Log.i("MyLogger", it?.throwable.message)
                    }
                }

            }, {
                Log.i("MyLogger", it.message)
            })
    }

    private fun loadNavigatorModule(navController:NavController){
        NavigatorModule.newInstance(navController).also(::loadKoinModules)
    }

}
