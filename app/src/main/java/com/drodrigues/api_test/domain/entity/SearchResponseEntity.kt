package com.drodrigues.api_test.domain.entity

internal data class SearchResponseEntity(
    val score: Double,
    val showEntity: ShowEntity = ShowEntity()
)
