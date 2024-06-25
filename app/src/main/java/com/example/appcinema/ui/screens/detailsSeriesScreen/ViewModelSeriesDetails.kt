package com.example.appcinema.ui.screens.detailsSeriesScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcinema.model.DetailsModel
import com.example.appcinema.network.CinemaApi
import kotlinx.coroutines.launch

class DetailsSeriesViewModel: ViewModel() {
    var cardDetails by mutableStateOf<DetailsModel?>(null)
        private set

    var cardTrailer by mutableStateOf(null)
        private set

    var idCard by mutableIntStateOf(0)
        private set

    fun getDetailsFun(id: Int) {
        idCard = id
        getTrailer(idCard)
        getDetails(idCard)
    }

    private fun getDetails(taskId: Int) {
        viewModelScope.launch {
            try{
                val listResult = CinemaApi.retrofitService.getSeriesDetails(taskId)
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
//                cardTrailer = listResult.results[0].key.toString()
            }catch (e: Exception){
                testAllDetails = e.message.toString()
            }
        }
    }

   var testAllDetails: String by mutableStateOf("")
       private set
}