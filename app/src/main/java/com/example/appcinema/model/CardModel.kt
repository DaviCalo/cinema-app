package com.example.appcinema.model

import kotlinx.serialization.Serializable

@Serializable
data class CardModel(
    val id: Int,
    val backdrop_path: String,
    val poster_path: String,
    val overview: String,
    val vote_average: Float,
    val release_date: String,
    val title: String
)