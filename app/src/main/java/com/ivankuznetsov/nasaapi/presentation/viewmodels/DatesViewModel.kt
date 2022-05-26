package com.ivankuznetsov.nasaapi.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.ivankuznetsov.nasaapi.data.NasaRepository
import com.ivankuznetsov.nasaapi.data.api.NasaApiFactory
import com.ivankuznetsov.nasaapi.data.model.Date
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class DatesViewModel
    @Inject constructor(
        private val savedStateHandle: SavedStateHandle
    ): ViewModel() {
    private val nasaRepository = NasaRepository(NasaApiFactory.nasaApi)
    val dates: MutableState<List<Date>?> = mutableStateOf(ArrayList())
    init {
        fetchDates()
    }
    private fun fetchDates(){
        viewModelScope.launch {
            try {
                val d: List<Date>? = nasaRepository.getDate()
                dates.value = d
            }
            catch (e: Exception){
               TODO("SNACK_BAR_ERROR")
            }

        }
    }
}