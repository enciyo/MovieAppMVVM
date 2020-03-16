package com.enciyo.movieapp.common.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseViewModel : ViewModel(){

    private val mCompositeDisposable = CompositeDisposable()

    fun Disposable?.track() {
        this?.let(mCompositeDisposable::add)
    }

    override fun onCleared() {
        mCompositeDisposable.dispose()
        super.onCleared()
    }


}