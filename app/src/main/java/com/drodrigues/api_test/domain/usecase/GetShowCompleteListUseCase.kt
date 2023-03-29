package com.drodrigues.tvdome.domain.usecase

import com.drodrigues.tvdome.domain.entity.ShowEntity
import com.drodrigues.tvdome.domain.repository.MainRepository

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