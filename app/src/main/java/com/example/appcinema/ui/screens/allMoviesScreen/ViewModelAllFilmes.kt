package com.example.appcinema.ui.screens.allMoviesScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.appcinema.network.CinemaApi
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import com.example.appcinema.model.CardModel

class MoviesViewModel: ViewModel() {
    var listAllMovies by mutableStateOf<Array<CardModel>?>(null)
        private set

    private val tempMovies = mutableListOf<CardModel>()

    var page: Int by mutableIntStateOf(1)

    init { getMoviesPopular(page) }

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
               testAllMovies = e.message.toString()
            }
        }
    }

    fun nextPage(){
        page++
        getMoviesPopular(page)
    }


    var testAllMovies: String by mutableStateOf("")
}
