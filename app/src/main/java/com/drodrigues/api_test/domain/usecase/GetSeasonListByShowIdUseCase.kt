package com.drodrigues.api_test.domain.usecase

import com.drodrigues.api_test.domain.entity.SeasonEntity
import com.drodrigues.api_test.domain.repository.MainRepository

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