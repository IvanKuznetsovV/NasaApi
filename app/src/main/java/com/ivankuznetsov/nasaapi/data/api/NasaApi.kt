package com.ivankuznetsov.nasaapi.data.api

import com.ivankuznetsov.nasaapi.data.model.Date

import com.ivankuznetsov.nasaapi.data.model.ImageDateResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NasaApi {
    @GET("all")
    fun getDatesAsync(): Deferred<Response<List<Date>>>

    @GET("date/{date}")
    fun getImageDateAsync(@Path("date") date: String): Deferred<Response<ImageDateResponse>>

    @GET("{year}/{month}/{day}/png/{id}.png")
    fun getImageAsync(@Path("year") year: String,
                 @Path("month") month: String,
                 @Path("day") day: String,
                 @Path("id") id: String)
}