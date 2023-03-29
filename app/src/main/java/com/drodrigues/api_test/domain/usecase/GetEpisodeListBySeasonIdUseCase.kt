package com.drodrigues.tvdome.domain.usecase

import com.drodrigues.tvdome.domain.entity.EpisodeEntity
import com.drodrigues.tvdome.domain.repository.MainRepository

internal interface GetEpisodeListBySeasonIdUseCase {
    suspend fun execute(seasonId: String): List<EpisodeEntity>
}

internal class GetEpisodeListBySeasonIdUseCaseImpl(
    private val mainRepository: MainRepository
) : GetEpisodeListBySeasonIdUseCase {

    override suspend fun execute(seasonId: String): List<EpisodeEntity> {
        return mainRepository.getEpisodeListBySeasonId(seasonId)
    }
}