package com.enciyo.movieapp.presentation.main

import android.os.Bundle
import com.enciyo.movieapp.R
import com.enciyo.movieapp.common.base.BaseFragment
import com.enciyo.movieapp.databinding.MainFragmentBinding

class MainFragment : BaseFragment<MainFragmentBinding, MainFragmentViewModel>(
    R.layout.main_fragment,
    MainFragmentViewModel::class
) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
