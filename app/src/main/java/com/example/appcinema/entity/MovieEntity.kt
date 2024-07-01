package com.example.appcinema.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appcinema.model.Movie
import java.util.UUID

@Entity(tableName = "movies")
class MovieEntity(
    @PrimaryKey
    val id: Int,
    val backdrop_path: String,
    val poster_path: String,
    val overview: String,
    val vote_average: Float,
    val release_date: String,
    val title: String
)

fun MovieEntity.toMovie() = Movie(
    id = id,
    backdrop_path =  backdrop_path,
    poster_path = poster_path,
    overview = overview,
    vote_average = vote_average,
    release_date = release_date,
    title = title

)
