package com.drodrigues.tvdome.domain.entity

internal data class SearchResponseEntity(
    val score: Double,
    val showEntity: ShowEntity = ShowEntity()
)
