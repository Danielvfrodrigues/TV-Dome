package com.drodrigues.tvdome.domain.usecase

import com.drodrigues.tvdome.domain.entity.ShowEntity
import com.drodrigues.tvdome.domain.repository.MainRepository

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