package com.ivankuznetsov.nasaapi.data

import android.util.Log
import com.ivankuznetsov.nasaapi.data.api.NasaApi
import com.ivankuznetsov.nasaapi.data.model.Date
import com.ivankuznetsov.nasaapi.data.model.ImageDate

class NasaRepository(private val api: NasaApi): BaseRepository() {

    suspend fun getDate(): List<Date>? {

        val datesResponse = safeApiCall(
            call = { api.getDatesAsync().await() },
            errorMessage = "Error Dates")
        return datesResponse?.toMutableList()
    }

    suspend fun getPhotoByDate(date: String): List<ImageDate>?{
        val photoByDateResponse = safeApiCall(
            call = { api.getImageDateAsync(date).await()},
            errorMessage = "Error Photo by date"
        )
        return photoByDateResponse?.toMutableList()
    }
}