package com.drodrigues.tvdome.domain.usecase

import com.drodrigues.tvdome.domain.entity.SearchResponseEntity
import com.drodrigues.tvdome.domain.repository.MainRepository

internal interface SearchShowByQueryUseCase {
    suspend fun execute(query: String): List<SearchResponseEntity>
}

internal class SearchShowByQueryUseCaseImpl(
    private val mainRepository: MainRepository
) : SearchShowByQueryUseCase {

    override suspend fun execute(query: String): List<SearchResponseEntity> {
        return mainRepository.searchShowByQuery(query)
    }
}