package com.drodrigues.api_test.data.repository

import com.drodrigues.api_test.data.model.toEntity
import com.drodrigues.api_test.data.model.toEntityList
import com.drodrigues.api_test.data.model.toSeasonEntityList
import com.drodrigues.api_test.data.source.ShowDataSource
import com.drodrigues.api_test.domain.entity.SeasonEntity
import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.domain.repository.ShowRepository

internal class ShowRepositoryImpl(
    private val showDataSource: ShowDataSource,
) : ShowRepository {

    override suspend fun getShowCompleteList(): List<ShowEntity> {
        return toEntityList(showDataSource.getShowCompleteList().body()!!)
    }

    override suspend fun getShowById(id: String): ShowEntity {
        return toEntity(showDataSource.getShowById(id).body()!!)
    }

    override suspend fun getSeasonListByShowId(showId: String): List<SeasonEntity> {
        return toSeasonEntityList(showDataSource.getSeasonListByShowId(showId).body()!!)
    }
}