package com.example.appcinema.model

import com.example.appcinema.entity.MovieEntity

data class Movie(
    val id: Int,
    val backdrop_path: String,
    val poster_path: String,
    val overview: String,
    val vote_average: Float,
    val release_date: String,
    val title: String
)

fun Movie.toMovieEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        backdrop_path = backdrop_path,
        poster_path = poster_path,
        overview = overview,
        vote_average = vote_average,
        release_date = release_date,
        title = title

    )
}