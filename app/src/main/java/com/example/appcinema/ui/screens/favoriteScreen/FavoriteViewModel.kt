package com.example.appcinema.ui.screens.favoriteScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcinema.model.CardModel
import com.example.appcinema.network.CinemaApi
import kotlinx.coroutines.launch


class FavoriteViewModel: ViewModel(){
    var listAllMovies by mutableStateOf<Array<CardModel>?>(null)
        private set

    var listAllSeries by mutableStateOf<Array<CardModel>?>(null)
        private set

    private val tempMovies = mutableListOf<CardModel>()

    private val tempSereis = mutableListOf<CardModel>()

    var page: Int by mutableIntStateOf(1)

    init {
        getMoviesPopular(page)
        getSeriesPopular(page)
    }

    private fun getMoviesPopular(page: Int) {
        viewModelScope.launch {
            try{
                val listResult = CinemaApi.retrofitService.getFavoriteMovies(page)
                val limitArray = listResult.results.size-1
                for (i in 0 .. limitArray){
                    tempMovies.add(listResult.results[i])
                }
                listAllMovies = tempMovies.toTypedArray()
                println(listAllMovies)
            }catch (e: Exception){
               println(e.message)
            }
        }
    }

    private fun getSeriesPopular(page: Int) {
        viewModelScope.launch {
            try{
                val listResult = CinemaApi.retrofitService.getFavoriteSeries(page)
                val limitArray = listResult.results.size-1
                for (i in 0 .. limitArray){
                    tempSereis.add(listResult.results[i])
                }
                listAllSeries = tempSereis.toTypedArray()
                if (listAllSeries != null){
                    println("asd")
                }
            }catch (e: Exception){
                println(e.message)
            }
        }
    }

    fun nextPage(){
        page++
        getMoviesPopular(page)
        getSeriesPopular(page)
    }

}
