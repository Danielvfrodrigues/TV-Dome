package com.drodrigues.api_test.domain.usecase

import com.drodrigues.api_test.domain.entity.SearchResponseEntity
import com.drodrigues.api_test.domain.repository.MainRepository

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