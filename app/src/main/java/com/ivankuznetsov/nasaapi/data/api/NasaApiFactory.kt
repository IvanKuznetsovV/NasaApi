package com.ivankuznetsov.nasaapi.data.api

import com.ivankuznetsov.nasaapi.util.BASE_URL
import com.ivankuznetsov.nasaapi.util.NASA_API_KEY
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


object NasaApiFactory {
    private val authInterceptor = Interceptor {chain->
        val newUrl = chain.request().url
            .newBuilder()
            .addQueryParameter("api_key", NASA_API_KEY)
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    private val nasaClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    private fun retrofit() : Retrofit = Retrofit.Builder()
        .client(nasaClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val nasaApi : NasaApi = retrofit().create(NasaApi::class.java)

}