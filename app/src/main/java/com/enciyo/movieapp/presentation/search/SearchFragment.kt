package com.enciyo.movieapp.presentation.search

import android.os.Bundle
import com.enciyo.movieapp.R
import com.enciyo.movieapp.common.base.BaseFragment
import com.enciyo.movieapp.databinding.SearchFragmentBinding

class SearchFragment : BaseFragment<SearchFragmentBinding,SearchFragmentViewModel>(
    R.layout.search_fragment,
    SearchFragmentViewModel::class
) {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }



}
