package com.enciyo.movieapp.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.enciyo.movieapp.BuildConfig
import com.enciyo.movieapp.data.remote.interceptors.ApiKeyInterceptor
import com.enciyo.movieapp.data.local.MovieDB
import com.enciyo.movieapp.data.remote.TrendingService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


object NetworkModule {

    fun newInstance() = module {
        factory { provideHttpLoggingInterceptor() }
        factory { provideApiKeyInterceptor() }
        factory { provideOkHttpClient(httpLoggingInterceptor = get(), apiKeyInterceptor = get()) }
        factory { provideRetrofit(okHttpClient = get()) }
        single { provideTrendingService(retrofit = get()) }
        single { provideMovieDatabase(context = androidContext()) }
        single { provideTrendingDao(movieDB = get()) }
    }

    private fun provideHttpLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private fun provideApiKeyInterceptor() =
        ApiKeyInterceptor()

    private fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, apiKeyInterceptor: ApiKeyInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(apiKeyInterceptor)
            .build()

    private fun provideRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build().also {
                Log.i("MyLogger",BuildConfig.BASE_URL)
            }

    private fun provideTrendingService(retrofit: Retrofit) =
        retrofit.create<TrendingService>()

    private fun provideMovieDatabase(context: Context) =
        Room.databaseBuilder(context, MovieDB::class.java, BuildConfig.MOVIE_DATABASE)
            .build()

    private fun provideTrendingDao(movieDB: MovieDB) =
        movieDB.trendingDao()

}
