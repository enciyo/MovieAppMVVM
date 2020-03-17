package com.enciyo.movieapp.presentation.trending

import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionManager
import com.enciyo.movieapp.common.ext.setupGrid


class TrendingBindingComponentImp : TrendingBindingComponent {


    override fun RecyclerView.loadAdapter(trendingAdapter: TrendingAdapter, viewModel: TrendingFragmentViewModel) {
        TransitionManager.beginDelayedTransition(this)
        this.setupGrid(trendingAdapter)
        trendingAdapter.listener = { item,extas->
            viewModel.onItemClicked(item,extas)
        }
    }

    override fun ProgressBar.isLoading(boolean: Boolean) {
        isVisible = boolean
    }

}