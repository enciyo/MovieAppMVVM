package com.enciyo.movieapp.presentation.moviedetail

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.enciyo.movieapp.R
import com.enciyo.movieapp.common.base.BaseFragment
import com.enciyo.movieapp.databinding.MovieDetailFragmentBinding

class MovieDetailFragment : BaseFragment<MovieDetailFragmentBinding, MovieDetailFragmentViewModel>(
    R.layout.movie_detail_fragment,
    MovieDetailFragmentViewModel::class
) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        MovieDetailComponent.inject()
        navArgs<MovieDetailFragmentArgs>()
            .value
            .trendingEntitiyArg?.let(mBinding::setModel)
    }

}
