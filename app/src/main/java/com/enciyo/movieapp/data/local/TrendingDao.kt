package com.enciyo.movieapp.data.local

import androidx.room.*
import com.enciyo.movieapp.data.model.TrendingEntitiy
import io.reactivex.Flowable
import io.reactivex.Single


@Dao
interface TrendingDao {
    @Query("SELECT * FROM trending_movie")
    fun getTrendingMovies(): Single<List<TrendingEntitiy?>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTrendingMovies(movieEntities: List<TrendingEntitiy>)

    @Query("SELECT * FROM trending_movie WHERE mId=:id")
    fun findMovie(id: Int): Single<TrendingEntitiy?>


    @Query("SELECT * FROM trending_movie WHERE mMediaType=:mediaType AND mTimeWindow=:timeWindow")
    fun findMovie(mediaType: String, timeWindow: String): Flowable<List<TrendingEntitiy>>

    @Query("SELECT * FROM trending_movie WHERE mTimeWindow=:timeWindow")
    fun findMovie(timeWindow: String): Flowable<List<TrendingEntitiy>>

}