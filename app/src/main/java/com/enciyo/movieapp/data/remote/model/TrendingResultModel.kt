package com.enciyo.movieapp.data.remote.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class TrendingResultModel(
    @SerializedName("adult")
    val mAdult: Boolean? = null, // false
    @SerializedName("backdrop_path")
    val mBackdropPath: String? = null, // /wXXaPMgrv96NkH8KD1TMdS2d7iq.jpg
    @SerializedName("first_air_date")
    val mFirstAirDate: String? = null, // 2010-10-31
    @SerializedName("genre_ids")
    val mGenreIds: List<Int?>? = null,
    @SerializedName("id")
    val mId: Int? = null, // 1402
    @SerializedName("media_type")
    val mMediaType: String? = null, // tv
    @SerializedName("name")
    val mName: String? = null, // The Walking Dead
    @SerializedName("origin_country")
    val mOriginCountry: List<String?>? = null,
    @SerializedName("original_language")
    val mOriginalLanguage: String? = null, // en
    @SerializedName("original_name")
    val mOriginalName: String? = null, // The Walking Dead
    @SerializedName("original_title")
    val mOriginalTitle: String? = null, // The Grudge
    @SerializedName("overview")
    val mOverview: String? = null, // Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.
    @SerializedName("popularity")
    val mPopularity: Double? = null, // 99.93
    @SerializedName("poster_path")
    val mPosterPath: String? = null, // /5l10EjdgPxu8Gbl5Ww6SWkVQH6T.jpg
    @SerializedName("release_date")
    val mReleaseDate: String? = null, // 2020-01-02
    @SerializedName("title")
    val mTitle: String? = null, // The Grudge
    @SerializedName("video")
    val mVideo: Boolean? = null, // false
    @SerializedName("vote_average")
    val mVoteAverage: Double? = null, // 7.3
    @SerializedName("vote_count")
    val mVoteCount: Int? = null, // 4609
    var mTimeWindow: String
) : Serializable