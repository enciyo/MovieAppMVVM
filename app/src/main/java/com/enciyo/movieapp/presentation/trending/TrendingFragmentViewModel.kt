package com.enciyo.movieapp.presentation.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.enciyo.movieapp.common.base.BaseViewModel
import com.enciyo.movieapp.common.resource.Resource
import com.enciyo.movieapp.data.model.TrendingEntitiy
import com.enciyo.movieapp.domain.TrendingUseCase
import com.hadilq.liveevent.LiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class TrendingFragmentViewModel(
    private val mTrendingUseCase: TrendingUseCase,
    private val mTrendingNavigator: TrendingNavigator
) : BaseViewModel() {

    private val mTrendingData = MutableLiveData<List<TrendingEntitiy?>>()
    val trendingData
        get() = mTrendingData as LiveData<List<TrendingEntitiy?>>

    private val mLoadingState = MutableLiveData<Boolean>()
    val loadingState
        get() = mLoadingState as LiveData<Boolean>



    fun fetchTrending() {
        mTrendingUseCase
            .fetchAllMoviesDay()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when (it) {
                    is Resource.Loading -> {
                        mLoadingState.value = true
                    }
                    is Resource.Success -> {
                        mTrendingData.value = it.data
                        mLoadingState.value = false
                    }
                    is Resource.Failure -> {
                        mLoadingState.value = false
                    }
                }
            }
            .track()
    }


    fun onItemClicked(item: TrendingEntitiy) {
        mTrendingNavigator.showDetail(item)
    }

}
