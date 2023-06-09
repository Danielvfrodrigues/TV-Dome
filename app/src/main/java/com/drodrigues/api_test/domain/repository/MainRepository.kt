package com.drodrigues.tvdome.domain.repository

import com.drodrigues.tvdome.domain.entity.EpisodeEntity
import com.drodrigues.tvdome.domain.entity.SearchResponseEntity
import com.drodrigues.tvdome.domain.entity.SeasonEntity
import com.drodrigues.tvdome.domain.entity.ShowEntity

internal interface MainRepository {

    suspend fun getShowCompleteList(): List<ShowEntity>
    suspend fun getShowById(id: String): ShowEntity
    suspend fun getSeasonListByShowId(showId: String): List<SeasonEntity>
    suspend fun getEpisodeListBySeasonId(seasonId: String): List<EpisodeEntity>
    suspend fun getEpisodeById(episodeId: String): EpisodeEntity
    suspend fun searchShowByQuery(query: String): List<SearchResponseEntity>
}