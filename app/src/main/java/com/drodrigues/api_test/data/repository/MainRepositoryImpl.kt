package com.drodrigues.api_test.data.repository

import com.drodrigues.api_test.data.model.toEntity
import com.drodrigues.api_test.data.model.toEntityList
import com.drodrigues.api_test.data.source.MainDataSource
import com.drodrigues.api_test.domain.entity.EpisodeEntity
import com.drodrigues.api_test.domain.entity.SeasonEntity
import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.domain.repository.MainRepository

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
}