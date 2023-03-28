package com.drodrigues.api_test.domain.entity

import com.drodrigues.api_test.data.model.ImageModel
import com.google.gson.annotations.SerializedName

internal data class ShowEntity(

    val id: Int = 0,
    val name: String = "",
    val imageEntity: ImageEntity = ImageEntity(),
    val scheduleEntity: ScheduleEntity = ScheduleEntity(),
    val genres: List<String> = listOf(),
    val summary: String = "",

)

internal data class ScheduleEntity(

    val days: List<String> = listOf(),
    val time: String = ""

)