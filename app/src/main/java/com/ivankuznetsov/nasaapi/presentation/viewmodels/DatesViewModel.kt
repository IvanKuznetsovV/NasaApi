package com.ivankuznetsov.nasaapi.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivankuznetsov.nasaapi.data.NasaRepository
import com.ivankuznetsov.nasaapi.data.api.NasaApiFactory
import com.ivankuznetsov.nasaapi.data.model.Date
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DatesViewModel
    @Inject constructor(

    ): ViewModel() {
    private val nasaRepository = NasaRepository(NasaApiFactory.nasaApi)
    val datesViewModelLiveData = MutableLiveData<MutableList<Date>?>()

    fun fetchDates(){
        viewModelScope.launch {
            val dates: MutableList<Date>? = nasaRepository.getDate()
            datesViewModelLiveData.postValue(dates)
        }
    }
}