package com.ivankuznetsov.nasaapi.data

import com.ivankuznetsov.nasaapi.data.api.NasaApi
import com.ivankuznetsov.nasaapi.data.model.Date

class NasaRepository(private val api: NasaApi): BaseRepository() {

    suspend fun getDate(): MutableList<Date>? {
        val datesResponse = safeApiCall(
            call = { api.getDatesAsync().await() },
            errorMessage = "Error Dates")
        return datesResponse?.toMutableList()
    }
}