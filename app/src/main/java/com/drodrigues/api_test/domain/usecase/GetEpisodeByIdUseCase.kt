package com.drodrigues.tvdome.domain.usecase

import com.drodrigues.tvdome.domain.entity.EpisodeEntity
import com.drodrigues.tvdome.domain.repository.MainRepository

internal interface GetEpisodeByIdUseCase {
    suspend fun execute(id: String): EpisodeEntity
}

internal class GetEpisodeByIdUseCaseImpl(
    private val mainRepository: MainRepository
) : GetEpisodeByIdUseCase {

    override suspend fun execute(id: String): EpisodeEntity {
        return mainRepository.getEpisodeById(id)
    }
}