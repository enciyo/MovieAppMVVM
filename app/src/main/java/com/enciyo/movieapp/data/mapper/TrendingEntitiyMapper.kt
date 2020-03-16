package com.enciyo.movieapp.data.mapper

import com.enciyo.movieapp.data.remote.model.TimeWindows


interface TrendingEntitiyMapper <T,E>{

    fun mapFrom(type:T,timeWindows: TimeWindows) : E

}