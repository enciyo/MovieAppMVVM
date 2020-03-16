package com.enciyo.movieapp.common.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlin.reflect.KFunction1

fun <T> LiveData<T>.observe(lifecycleOwner: LifecycleOwner, kFunction1: KFunction1<T, Unit>) {
    this.observe(lifecycleOwner, Observer {
        kFunction1(it)
    })
}