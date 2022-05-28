package com.ivankuznetsov.nasaapi.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.ivankuznetsov.nasaapi.data.NasaRepository
import com.ivankuznetsov.nasaapi.data.api.NasaApiFactory
import com.ivankuznetsov.nasaapi.data.model.Date
import com.ivankuznetsov.nasaapi.util.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
const val DATE_ID = "DateId"
@HiltViewModel
class DatesViewModel
    @Inject constructor(
        private val savedStateHandle: SavedStateHandle,
        ): ViewModel() {
    private val nasaRepository = NasaRepository(NasaApiFactory.nasaApi)
    val dates: MutableState<List<Date>?> = mutableStateOf(ArrayList())
    val dateId: MutableState<String> = mutableStateOf("")

    init { fetchDates() }
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
    fun getDateId(id: String){
        Log.d(TAG, "getDateId")
        dateId.value = id
        savedStateHandle[DATE_ID] = dateId

    }
}