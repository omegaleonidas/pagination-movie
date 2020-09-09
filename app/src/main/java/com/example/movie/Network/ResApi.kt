package com.example.movie.Network

import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ResApi {

    companion object {
        val baseUrl = "https://api.themoviedb.org/3/"

        fun restApi(): MovieServices {

            val intercepton = HttpLoggingInterceptor()
            intercepton.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttp = OkHttpClient().newBuilder().addInterceptor(intercepton).build()

            val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .client(okHttp)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
            return retrofit.create(MovieServices::class.java)
        }
    }
}