package com.drodrigues.tvdome.domain.entity

internal data class ShowEntity(

    val id: Int = 0,
    val name: String = "",
    val imageEntity: ImageEntity = ImageEntity(),
    val scheduleEntity: ScheduleEntity = ScheduleEntity(),
    val genres: List<String> = listOf(),
    val summary: String? = "",

)

internal data class ScheduleEntity(

    val days: List<String> = listOf(),
    val time: String = ""

)