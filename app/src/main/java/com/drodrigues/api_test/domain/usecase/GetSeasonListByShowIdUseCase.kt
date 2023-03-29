package com.drodrigues.tvdome.domain.usecase

import com.drodrigues.tvdome.domain.entity.SeasonEntity
import com.drodrigues.tvdome.domain.repository.MainRepository

internal interface GetSeasonListByShowIdUseCase {
    suspend fun execute(showId: String): List<SeasonEntity>
}

internal class GetSeasonListByShowIdUseCaseImpl(
    private val mainRepository: MainRepository
) : GetSeasonListByShowIdUseCase {

    override suspend fun execute(showId: String): List<SeasonEntity> {
        return mainRepository.getSeasonListByShowId(showId)
    }
}