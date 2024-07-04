package com.example.appcinema.ui.screens.detailsSeriesScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcinema.model.DetailsModel
import com.example.appcinema.model.FavoriteRequest
import com.example.appcinema.network.CinemaApi
import kotlinx.coroutines.launch

class DetailsSeriesViewModel: ViewModel() {
    var cardDetails by mutableStateOf<DetailsModel?>(null)
        private set

    var cardTrailer:String by mutableStateOf("")

    var isFavorite by mutableStateOf(false)

    private var idCard: Int by mutableIntStateOf(0)

    fun getDetailsFun(id: Int) {
        idCard = id
        getTrailer(idCard)
        getDetails(idCard)
        findFavorite(idCard)
    }

    private fun getDetails(taskId: Int) {
        viewModelScope.launch {
            try{
                val listResult = CinemaApi.retrofitService.getSeriesDetails(taskId)
                cardDetails = listResult
            }catch (e: Exception){
                println(e.message)
            }
        }
    }

    private fun getTrailer(taskId: Int) {
        viewModelScope.launch {
            try{
                val listResult = CinemaApi.retrofitService.getTrailerSeries(taskId)
                cardTrailer = listResult.results[1].key
            }catch (e: Exception){
                println(e.message)
            }
        }
    }

    fun setFavorite(id: Int, type: String, isFavorite: Boolean){
        viewModelScope.launch {
            try{
                val response = FavoriteRequest(id, type, isFavorite)
                CinemaApi.retrofitService.setSerieFavorite(response)
            }catch (e: Exception){
                println(e.message)
            }
        }
    }

    private fun findFavorite(id: Int){
        viewModelScope.launch {
            try{
                val listResult = CinemaApi.retrofitService.getFavoriteSeries(1)
                for (i in 0..<listResult.results.size){
                    if (listResult.results[i].id == id){
                        isFavorite = true
                    }
                }
            }catch (e: Exception){
                println(e.message)
            }
        }
    }
}