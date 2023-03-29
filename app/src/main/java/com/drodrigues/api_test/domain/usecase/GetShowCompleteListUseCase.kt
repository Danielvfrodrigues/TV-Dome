package com.drodrigues.api_test.domain.usecase

import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.domain.repository.MainRepository

internal interface GetShowCompleteListUseCase {
    suspend fun execute(): List<ShowEntity>
}

internal class GetShowCompleteListUseCaseImpl(
    val mainRepository: MainRepository,
) : GetShowCompleteListUseCase {

    override suspend fun execute(): List<ShowEntity>{
        return mainRepository.getShowCompleteList()
    }
}