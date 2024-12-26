package com.example.appcinema.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("https://api.themoviedb.org/3/")
    .build()

object CinemaApi{
    val retrofitService : RoutesApiService by lazy {
        retrofit.create(RoutesApiService::class.java)
    }
}