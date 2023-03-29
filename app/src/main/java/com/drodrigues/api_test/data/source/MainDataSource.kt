package com.drodrigues.api_test.data.source

import com.drodrigues.api_test.data.model.EpisodeModel
import com.drodrigues.api_test.data.model.SeasonModel
import com.drodrigues.api_test.data.model.ShowModel
import retrofit2.Response

internal interface MainDataSource {

    suspend fun getShowCompleteList(): Response<List<ShowModel>>
    suspend fun getShowById(id: String): Response<ShowModel>
    suspend fun getSeasonListByShowId(showId: String): Response<List<SeasonModel>>
    suspend fun getEpisodeListBySeasonId(seasonId: String): Response<List<EpisodeModel>>
    suspend fun getEpisodeById(episodeId: String): Response<EpisodeModel>

}