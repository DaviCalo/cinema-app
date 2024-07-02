package com.example.appcinema.ui.screens.detailsMoviesScreen


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcinema.model.DetailsModel
import com.example.appcinema.model.TrailerModal
import com.example.appcinema.network.CinemaApi
import kotlinx.coroutines.launch

class DetailsMoviesViewModel: ViewModel() {
    var cardDetails by mutableStateOf<DetailsModel?>(null)
        private set

    var cardTrailer:String by mutableStateOf("")

    var idCard by mutableIntStateOf(0)
        private set

    fun getDetailsFun(idCards: Int) {
        this.idCard = idCards
        getTrailer(idCard)
        getDetails(idCard)
    }

    private fun getDetails(taskId: Int) {
        viewModelScope.launch {
            try{
                val listResult = CinemaApi.retrofitService.getMoviesDetails(taskId)
                cardDetails = listResult
            }catch (e: Exception){
                testAllDetails = e.message.toString()
            }
        }
    }

    fun getTrailer(taskId: Int) {
        viewModelScope.launch {
            try{
                val listResult = CinemaApi.retrofitService.getTrailerSeries(taskId)
               cardTrailer = listResult.results[1].key
            }catch (e: Exception){
                testAllDetails = e.message.toString()
            }
        }
    }

    var testAllDetails: String by mutableStateOf("")
        private set
}