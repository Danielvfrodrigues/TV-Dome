package com.drodrigues.api_test.domain.usecase

import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.domain.repository.ShowRepository

internal interface GetShowByIdUseCase {
    suspend fun execute(id: String): ShowEntity
}
internal class GetShowByIdUseCaseImpl(
    private val showRepository: ShowRepository
) : GetShowByIdUseCase {

    override suspend fun execute(id: String): ShowEntity {
        return showRepository.getShowById(id)
    }
}