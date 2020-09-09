package com.example.movie.Network

import com.example.movie.Model.Response
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieServices {

    @GET("movie/5/lists")
    fun getMovie(

        @Query("api_key") apikey: String,
        @Query("laguage") laguage: String,
        @Query("page") page: Long,
        @Query("total_result") result: Int):Flowable<Response>

}