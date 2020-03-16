package com.enciyo.movieapp.presentation.trending

import android.os.Bundle
import android.widget.Toast
import com.enciyo.movieapp.R
import com.enciyo.movieapp.common.base.BaseFragment
import com.enciyo.movieapp.common.ext.observe
import com.enciyo.movieapp.data.model.TrendingEntitiy
import com.enciyo.movieapp.databinding.TrendingFragmentBinding
import org.koin.android.ext.android.inject

class TrendingFragment : BaseFragment<TrendingFragmentBinding, TrendingFragmentViewModel>(
    R.layout.trending_fragment,
    TrendingFragmentViewModel::class
) {

    private val mTrendingAdapter by inject<TrendingAdapter>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        TrendingComponent.inject()

        with(mBinding) {
            adapter = mTrendingAdapter
            viewModel = mViewModel
        }

        with(mViewModel) {
            trendingData.observe(viewLifecycleOwner, ::trendingDataObserver)
            fetchTrending()
        }


    }

    private fun trendingDataObserver(list: List<TrendingEntitiy?>) {
        mTrendingAdapter.submitList(list)
    }


}

