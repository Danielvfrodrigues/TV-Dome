package com.drodrigues.api_test.framework

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class AppConnector {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.tvmaze.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getRetrofit(): Retrofit {
        return retrofit
    }
}