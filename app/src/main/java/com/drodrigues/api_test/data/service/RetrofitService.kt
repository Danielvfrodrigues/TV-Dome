package com.drodrigues.tvdome.data.service

import com.drodrigues.tvdome.data.model.EpisodeModel
import com.drodrigues.tvdome.data.model.SearchResponseModel
import com.drodrigues.tvdome.data.model.SeasonModel
import com.drodrigues.tvdome.data.model.ShowModel
import com.drodrigues.tvdome.data.util.*
import com.drodrigues.tvdome.data.util.API_ENDPOINT_GET_SEASONS_BY_SHOW_ID
import com.drodrigues.tvdome.data.util.API_ENDPOINT_GET_SHOW_BY_ID
import com.drodrigues.tvdome.data.util.API_ENDPOINT_GET_SHOW_COMPLETE_LIST
import com.drodrigues.tvdome.data.util.API_ENDPOINT_SEARCH_SHOW
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface RetrofitService {

    @GET(API_ENDPOINT_GET_SHOW_COMPLETE_LIST)
    suspend fun getAllShows(): Response<List<ShowModel>>

    @GET(API_ENDPOINT_GET_SHOW_BY_ID)
    suspend fun getShowById(
        @Path("id") id: String
    ): Response<ShowModel>

    @GET(API_ENDPOINT_GET_SEASONS_BY_SHOW_ID)
    suspend fun getSeasonsByShowId(
        @Path("showId") showId: String
    ): Response<List<SeasonModel>>

    @GET(API_ENDPOINT_GET_EPISODE_LIST_BY_SEASON_ID)
    suspend fun getEpisodeListBySeasonId(
        @Path("seasonId") seasonId: String
    ): Response<List<EpisodeModel>>

    @GET(API_ENDPOINT_GET_EPISODE_BY_ID)
    suspend fun getEpisodeById(
        @Path("episodeId") episodeId: String
    ): Response<EpisodeModel>

    @GET(API_ENDPOINT_SEARCH_SHOW)
    suspend fun searchShow(
        @Query(":query") query: String
    ): Response<List<SearchResponseModel>>
}