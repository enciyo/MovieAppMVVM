package com.enciyo.movieapp.presentation.trending

import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView


interface TrendingBindingComponent {


    @BindingAdapter("loadAdapter","itemOnClicked")
    fun RecyclerView.loadAdapter(trendingAdapter: TrendingAdapter,viewModel: TrendingFragmentViewModel)

    @BindingAdapter("isLoading")
    fun ProgressBar.isLoading(boolean: Boolean)



}