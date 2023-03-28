package com.drodrigues.api_test.data.service

import com.drodrigues.api_test.data.model.ShowModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

internal interface RetrofitService {

    @GET("shows")
    suspend fun getAllShows(): Response<List<ShowModel>>

    @GET("shows/{id}")
    suspend fun getShowById(
        @Path("id") id: String
    ): Response<ShowModel>
}