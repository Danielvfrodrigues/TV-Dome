package com.drodrigues.api_test.domain.repository

import com.drodrigues.api_test.domain.entity.SeasonEntity
import com.drodrigues.api_test.domain.entity.ShowEntity

internal interface ShowRepository {

    suspend fun getShowCompleteList(): List<ShowEntity>
    suspend fun getShowById(id: String): ShowEntity
    suspend fun getSeasonListByShowId(showId: String): List<SeasonEntity>
}