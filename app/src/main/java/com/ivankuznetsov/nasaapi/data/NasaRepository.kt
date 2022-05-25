package com.ivankuznetsov.nasaapi.data

import android.util.Log
import com.ivankuznetsov.nasaapi.data.api.NasaApi
import com.ivankuznetsov.nasaapi.data.model.Date

class NasaRepository(private val api: NasaApi): BaseRepository() {

    suspend fun getDate(): List<Date>? {

        val datesResponse = safeApiCall(
            call = { api.getDatesAsync().await() },
            errorMessage = "Error Dates")
        return datesResponse?.toMutableList()
    }
}