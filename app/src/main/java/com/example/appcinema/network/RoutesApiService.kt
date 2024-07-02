package com.example.appcinema.network

import com.example.appcinema.model.DetailsModel
import com.example.appcinema.model.ResponseAllCards
import com.example.appcinema.model.TrailerModal
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


private const val envVar: String = "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4OTQwNzYzZDQ5NDY0YTE1OTIyMmRiNGIwZDFmMWYxNCIsIm5iZiI6MTcxOTI2ODkxMS4wNjc5Niwic3ViIjoiNjY3OTYzZDdkYmM5NTZkNDdmOWY0NjViIiwic2NvcGVzIjpbImFwaV9yZWFkIl0sInZlcnNpb24iOjF9.d52ua3AhPh3GH35RZp8tPF_hGAyirOSoUasG3ukx9_g"

interface RoutesApiService{
    @Headers(envVar, "accept: application/json")
    @GET("movie/popular?language=pt-br")
    suspend fun getMoviesPopular(@Query("page") pageSize: Int): ResponseAllCards

    @Headers(envVar, "accept: application/json")
    @GET("tv/popular?language=pt-br")
    suspend fun getSeriesPopular(@Query("page") pageSize: Int): ResponseAllCards

    @Headers(envVar, "accept: application/json")
    @GET("tv/{task_id}/videos?language=pt-br")
    suspend fun getTrailerSeries(@Path("task_id") taskId: Int): TrailerModal

    @Headers(envVar, "accept: application/json")
    @GET("movie/{task_id}/videos?language=pt-br")
    suspend fun getTrailerMovies(@Path("task_id") taskId: Int): TrailerModal

    @Headers(envVar, "accept: application/json")
    @GET("tv/{series_id}?language=pt-br")
    suspend fun getSeriesDetails(@Path("series_id") taskId: Int): DetailsModel

    @Headers(envVar, "accept: application/json")
    @GET("movie/{movie_id}?language=pt-br")
    suspend fun getMoviesDetails(@Path("movie_id") taskId: Int): DetailsModel
}
