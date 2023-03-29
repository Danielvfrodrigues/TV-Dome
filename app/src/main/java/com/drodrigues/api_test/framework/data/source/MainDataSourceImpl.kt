package com.drodrigues.api_test.framework.data.source

import com.drodrigues.api_test.data.model.EpisodeModel
import com.drodrigues.api_test.data.model.SeasonModel
import com.drodrigues.api_test.data.model.ShowModel
import com.drodrigues.api_test.data.service.RetrofitService
import com.drodrigues.api_test.data.source.MainDataSource
import retrofit2.Response
import retrofit2.Retrofit

internal class MainDataSourceImpl(

    retrofit: Retrofit

) : MainDataSource {

    private val service: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }

    override suspend fun getShowCompleteList(): Response<List<ShowModel>> {
        return service.getAllShows()
    }

    override suspend fun getShowById(id: String): Response<ShowModel> {
        return service.getShowById(id)
    }

    override suspend fun getSeasonListByShowId(showId: String): Response<List<SeasonModel>> {
        return service.getSeasonsByShowId(showId)
    }

    override suspend fun getEpisodeListBySeasonId(seasonId: String): Response<List<EpisodeModel>> {
        return service.getEpisodeListBySeasonId(seasonId)
    }
}