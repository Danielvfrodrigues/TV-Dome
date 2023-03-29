package com.drodrigues.api_test.data.model

import com.drodrigues.api_test.domain.entity.ImageEntity
import com.drodrigues.api_test.domain.entity.ScheduleEntity
import com.drodrigues.api_test.domain.entity.ShowEntity
import com.google.gson.annotations.SerializedName


internal data class ShowModel(

    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("image")
    val imageModel: ImageModel = ImageModel(),
    @SerializedName("schedule")
    val scheduleModel: ScheduleModel = ScheduleModel(),
    @SerializedName("genres")
    val genres: List<String> = listOf(),
    @SerializedName("summary")
    val summary: String? = "",

    )

internal data class ScheduleModel(

    @SerializedName("days")
    val days: List<String> = listOf(),
    @SerializedName("time")
    val time: String = ""

)

internal fun toEntity(model: ShowModel): ShowEntity {
    return ShowEntity(
        id = model.id,
        name = model.name,
            imageEntity = ImageEntity(
                medium = model.imageModel.medium,
                original = model.imageModel.original
            ),
            scheduleEntity = ScheduleEntity(
                days = model.scheduleModel.days,
                time = model.scheduleModel.time
            ),
            genres = model.genres,
            summary = model.summary
    )
}

internal fun toEntityList(initial: List<ShowModel>): List<ShowEntity> {
    return initial.map { toEntity(it) }
}