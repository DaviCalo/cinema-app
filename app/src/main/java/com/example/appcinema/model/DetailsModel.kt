package com.example.appcinema.model

data class DetailsModel(
    val backdrop_path: String,
    val first_air_date: String,
    val release_date: String,
    val id: Int,
    val name: String,
    val title: String,
    val overview: String,
    val poster_path: String,
    val vote_average: Double
)
