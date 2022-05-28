package com.ivankuznetsov.nasaapi.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivankuznetsov.nasaapi.data.NasaRepository
import com.ivankuznetsov.nasaapi.data.api.NasaApiFactory
import com.ivankuznetsov.nasaapi.data.model.ImageDate
import com.ivankuznetsov.nasaapi.util.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoByDateViewModel
    @Inject constructor(
        private val state: SavedStateHandle
    ): ViewModel() {
    private val nasaRepository = NasaRepository(NasaApiFactory.nasaApi)
    val photoByDate: MutableState<List<ImageDate>?> = mutableStateOf(ArrayList())
    init{
        state.get<String>(DATE_ID)?.let{date ->
            Log.d(TAG,"get<String>" )
            fetchPhotoByDate(date)
        }
    }
    private fun fetchPhotoByDate(date: String){
        Log.d(TAG,"fetchPhotoByDate" )
        viewModelScope.launch {
            try{
                val p: List<ImageDate>? = nasaRepository.getPhotoByDate(date)
                photoByDate.value = p
            }
            catch (e: Exception){
                TODO("SNACK_BAR_ERROR")
            }
        }
    }
}