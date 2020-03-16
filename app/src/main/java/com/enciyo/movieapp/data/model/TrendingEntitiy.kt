package com.enciyo.movieapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "trending_movie")
data class TrendingEntitiy(
    @PrimaryKey(autoGenerate = false)
    val mId: Int? = null, // 1402
    val mAdult: Boolean? = null, // false
    val mBackdropPath: String? = null, // /wXXaPMgrv96NkH8KD1TMdS2d7iq.jpg
    val mFirstAirDate: String? = null, // 2010-10-31
    val mMediaType: String? = null, // tv
    val mName: String? = null, // The Walking Dead
    val mOriginalName: String? = null, // The Walking Dead
    val mOriginalTitle: String? = null, // The Grudge
    val mOverview: String? = null, // Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.
    val mPopularity: Double? = null, // 99.93
    val mPosterPath: String? = null, // /5l10EjdgPxu8Gbl5Ww6SWkVQH6T.jpg
    val mTitle: String? = null, // The Grudge
    val mVoteAverage: Double? = null, // 7.3
    val mVoteCount: Int? = null, // 4609
    val mTimeWindow: String? = null
) : Serializable{
    val safeName
        get() = when {
            mOriginalTitle!=null -> mOriginalTitle
            mName!=null -> mName
            mOriginalName!=null -> mOriginalName
            mTitle!=null -> mTitle
            else -> ""
        }


}