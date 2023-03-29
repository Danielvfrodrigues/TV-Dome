package com.drodrigues.api_test.domain.usecase

import com.drodrigues.api_test.domain.entity.EpisodeEntity
import com.drodrigues.api_test.domain.repository.MainRepository

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