package com.example.appcinema.ui.screens.homeScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcinema.model.CardModel
import com.example.appcinema.network.CinemaApi
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    var listAllMovies by mutableStateOf<Array<CardModel>?>(null)
        private set

    var listAllSeries by mutableStateOf<Array<CardModel>?>(null)
        private set

    var listAllMoviesFavorite by mutableStateOf<Array<CardModel>?>(null)
        private set

    var listAllSeriesFavorite  by mutableStateOf<Array<CardModel>?>(null)
        private set

    private val tempMoviesFavorite = mutableListOf<CardModel>()
    private val tempSeriesFavorite = mutableListOf<CardModel>()
    private val tempMovies = mutableListOf<CardModel>()
    private val tempSeries = mutableListOf<CardModel>()

    private var pageMovies: Int by mutableIntStateOf(1)
    private var pageSeries: Int by mutableIntStateOf(1)
    private var pageFavorite: Int by mutableIntStateOf(1)

    init {
        getMoviesPopular(pageMovies)
        getSeriesPopular(pageSeries)
        getMoviesPopularFavorite(pageFavorite)
        getSeriesPopularFavorite(pageFavorite)
    }

    private fun getMoviesPopular(page: Int) {
        viewModelScope.launch {
            try{
                val listResult = CinemaApi.retrofitService.getMoviesPopular(page)
                val limitArray = listResult.results.size-1
                for (i in 0 .. limitArray){
                    tempMovies.add(listResult.results[i])
                }
                listAllMovies = tempMovies.toTypedArray()
            }catch (e: Exception){
                println(e.message)
            }
        }
    }

    private fun getSeriesPopular(page: Int) {
        viewModelScope.launch {
            try{
                val listResult = CinemaApi.retrofitService.getSeriesPopular(page)
                val limitArray = listResult.results.size-1
                for (i in 0 .. limitArray){
                    tempSeries.add(listResult.results[i])
                }
                listAllSeries = tempSeries.toTypedArray()
            }catch (e: Exception){
                println(e.message)
            }
        }
    }

    private fun getMoviesPopularFavorite(page: Int) {
        viewModelScope.launch {
            try{
                val listResult = CinemaApi.retrofitService.getFavoriteMovies(page)
                val limitArray = listResult.results.size-1
                for (i in 0 .. limitArray){
                    tempMoviesFavorite.add(listResult.results[i])
                }
                listAllMoviesFavorite = tempMoviesFavorite.toTypedArray()
            }catch (e: Exception){
                println(e.message)
            }
        }
    }

    private fun getSeriesPopularFavorite(page: Int) {
        viewModelScope.launch {
            try{
                val listResult = CinemaApi.retrofitService.getFavoriteSeries(page)
                val limitArray = listResult.results.size-1
                for (i in 0 .. limitArray){
                    tempSeriesFavorite.add(listResult.results[i])
                }
                listAllSeriesFavorite = tempSeriesFavorite.toTypedArray()
            }catch (e: Exception){
                println(e.message)
            }
        }
    }

    fun nextPageMovies(){
        pageMovies++
        getMoviesPopular(pageMovies)
    }

    fun nextPageSeries(){
        pageSeries++
        getSeriesPopular(pageSeries)
    }

    fun nextPageSeriesFavorite(){
        pageFavorite++
        getMoviesPopularFavorite(pageFavorite)
        getSeriesPopularFavorite(pageFavorite)
    }
}
