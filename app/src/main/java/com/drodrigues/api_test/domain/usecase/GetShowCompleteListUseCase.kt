package com.drodrigues.api_test.domain.usecase

import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.domain.repository.ShowRepository

internal interface GetShowCompleteListUseCase {
    suspend fun execute(): List<ShowEntity>
}

internal class GetShowCompleteListUseCaseImpl(
    val showRepository: ShowRepository,
) : GetShowCompleteListUseCase {

    override suspend fun execute(): List<ShowEntity>{
        return showRepository.getShowCompleteList()
    }
}