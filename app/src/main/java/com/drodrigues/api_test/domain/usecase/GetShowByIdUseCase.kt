package com.drodrigues.api_test.domain.usecase

import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.domain.repository.MainRepository

internal interface GetShowByIdUseCase {
    suspend fun execute(id: String): ShowEntity?
}
internal class GetShowByIdUseCaseImpl(
    private val mainRepository: MainRepository
) : GetShowByIdUseCase {

    override suspend fun execute(id: String): ShowEntity {
        return mainRepository.getShowById(id)
    }
}