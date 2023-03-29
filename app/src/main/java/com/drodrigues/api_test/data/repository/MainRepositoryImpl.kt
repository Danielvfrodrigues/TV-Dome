package com.drodrigues.tvdome.data.repository

import com.drodrigues.tvdome.data.model.toEntity
import com.drodrigues.tvdome.data.model.toEntityList
import com.drodrigues.tvdome.data.source.MainDataSource
import com.drodrigues.tvdome.domain.entity.EpisodeEntity
import com.drodrigues.tvdome.domain.entity.SearchResponseEntity
import com.drodrigues.tvdome.domain.entity.SeasonEntity
import com.drodrigues.tvdome.domain.entity.ShowEntity
import com.drodrigues.tvdome.domain.repository.MainRepository

internal class MainRepositoryImpl(
    private val mainDataSource: MainDataSource,
) : MainRepository {

    override suspend fun getShowCompleteList(): List<ShowEntity> {
        return toEntityList(mainDataSource.getShowCompleteList().body()!!)
    }

    override suspend fun getShowById(id: String): ShowEntity {
        return toEntity(mainDataSource.getShowById(id).body()!!)
    }

    override suspend fun getSeasonListByShowId(showId: String): List<SeasonEntity> {
        return toEntityList(mainDataSource.getSeasonListByShowId(showId).body()!!)
    }

    override suspend fun getEpisodeListBySeasonId(seasonId: String): List<EpisodeEntity> {
        return toEntityList(mainDataSource.getEpisodeListBySeasonId(seasonId).body()!!)
    }

    override suspend fun getEpisodeById(episodeId: String): EpisodeEntity {
        return toEntity(mainDataSource.getEpisodeById(episodeId).body()!!)
    }

    override suspend fun searchShowByQuery(query: String): List<SearchResponseEntity> {
        return toEntityList(mainDataSource.searchShowByQuery(query).body()!!)
    }

}