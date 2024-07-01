package com.example.appcinema.database

import androidx.room.Dao
import androidx.room.Query
import com.example.appcinema.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun findAll(): Flow<List<MovieEntity>>


}