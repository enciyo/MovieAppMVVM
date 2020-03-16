package com.enciyo.movieapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.enciyo.movieapp.data.model.TrendingEntitiy

@Database(entities = [TrendingEntitiy::class], version = 1,exportSchema = false)
abstract class MovieDB : RoomDatabase() {
    abstract fun trendingDao(): TrendingDao

}