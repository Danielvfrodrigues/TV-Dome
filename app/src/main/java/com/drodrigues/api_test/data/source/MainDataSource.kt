package com.drodrigues.tvdome.data.source

import com.drodrigues.tvdome.data.model.EpisodeModel
import com.drodrigues.tvdome.data.model.SearchResponseModel
import com.drodrigues.tvdome.data.model.SeasonModel
import com.drodrigues.tvdome.data.model.ShowModel
import retrofit2.Response

internal interface MainDataSource {

    suspend fun getShowCompleteList(): Response<List<ShowModel>>
    suspend fun getShowById(id: String): Response<ShowModel>
    suspend fun getSeasonListByShowId(showId: String): Response<List<SeasonModel>>
    suspend fun getEpisodeListBySeasonId(seasonId: String): Response<List<EpisodeModel>>
    suspend fun getEpisodeById(episodeId: String): Response<EpisodeModel>
    suspend fun searchShowByQuery(query: String): Response<List<SearchResponseModel>>

}