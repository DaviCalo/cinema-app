package com.example.appcinema.ui.screens.allSeriesScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcinema.model.CardModel
import com.example.appcinema.network.CinemaApi
import kotlinx.coroutines.launch

class SeriesViewModel: ViewModel() {
    var listAllSeries by mutableStateOf<Array<CardModel>?>(null)
        private set

    private val tempSeries = mutableListOf<CardModel>()

    var page: Int by mutableIntStateOf(1)

    init { getListAllSeriesPopular(1) }

    private fun getListAllSeriesPopular(page: Int) {
        viewModelScope.launch {
            try{
                val listResult = CinemaApi.retrofitService.getSeriesPopular(page)
                val limitArray = listResult.results.size-1
                for (i in 0 .. limitArray){
                    tempSeries.add(listResult.results[i])
                }
                listAllSeries = tempSeries.toTypedArray()
            }catch (e: Exception){
                testAllSeries = e.message.toString()
            }
        }
    }

    fun nextPage(){
        page++
        getListAllSeriesPopular(page)
    }

   var testAllSeries: String by mutableStateOf("")
       private set
}