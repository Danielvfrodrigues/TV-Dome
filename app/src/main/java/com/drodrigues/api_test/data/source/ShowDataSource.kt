package com.drodrigues.api_test.data.source

import com.drodrigues.api_test.data.model.ShowModel
import retrofit2.Response

internal interface ShowDataSource {

    suspend fun getShowCompleteList(): Response<List<ShowModel>>
    suspend fun getShowById(id: String): Response<ShowModel>
}