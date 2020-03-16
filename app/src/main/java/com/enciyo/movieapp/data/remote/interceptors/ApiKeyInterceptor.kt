package com.enciyo.movieapp.data.remote.interceptors

import android.util.Log
import com.enciyo.movieapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response


class ApiKeyInterceptor : Interceptor {
    companion object {
        private const val QUERY_API_KEY = "api_key"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        synchronized(this) {
            val originalRequest = chain.request()
            val originalHttpUrl = originalRequest.url
            val httpUrl = originalHttpUrl
                .newBuilder()
                .addQueryParameter(QUERY_API_KEY, BuildConfig.API_KEY)
                .build()

            val newRequest = originalRequest.newBuilder()
                .url(httpUrl)
                .build()

            return chain.proceed(newRequest)
        }
    }
}
