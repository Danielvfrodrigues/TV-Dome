package com.drodrigues.api_test.domain.entity

internal data class EpisodeEntity(

    val id: String,
    val name: String,
    val number: String,
    val season: String,
    val runtime: String,
    val summary: String,
    val imageEntity: ImageEntity = ImageEntity()

)
