package com.enciyo.movieapp.data.mapper

import com.enciyo.movieapp.data.remote.model.TimeWindows
import com.enciyo.movieapp.data.remote.model.TrendingResultModel
import com.enciyo.movieapp.data.model.TrendingEntitiy

class TrendingEntitiyMapperImp : TrendingEntitiyMapper<TrendingResultModel, TrendingEntitiy> {

    override fun mapFrom(type: TrendingResultModel, timeWindows: TimeWindows): TrendingEntitiy {
        return TrendingEntitiy(
            mId = type.mId,
            mAdult = type.mAdult,
            mBackdropPath = type.mBackdropPath,
            mFirstAirDate = type.mFirstAirDate,
            mMediaType = type.mMediaType,
            mName = type.mName,
            mOriginalName = type.mOriginalName,
            mOriginalTitle = type.mOriginalTitle,
            mOverview = type.mOverview,
            mPopularity = type.mPopularity,
            mPosterPath = type.mPosterPath,
            mTimeWindow = timeWindows.path,
            mTitle = type.mTitle,
            mVoteAverage = type.mVoteAverage,
            mVoteCount = type.mVoteCount
        )
    }

}