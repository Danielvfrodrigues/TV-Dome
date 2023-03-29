package com.drodrigues.api_test.data.model

import com.drodrigues.api_test.domain.entity.ImageEntity
import com.drodrigues.api_test.domain.entity.ScheduleEntity
import com.drodrigues.api_test.domain.entity.SearchResponseEntity
import com.drodrigues.api_test.domain.entity.ShowEntity
import com.google.gson.annotations.SerializedName

internal data class SearchResponseModel(

    @SerializedName("score")
    val score: Double,
    @SerializedName("show")
    val showModel: ShowModel = ShowModel()
)

internal fun toEntity(model: SearchResponseModel): SearchResponseEntity {
    return SearchResponseEntity(
        score = model.score,
        showEntity = ShowEntity(
            id = model.showModel.id,
            name = model.showModel.name,
            imageEntity = ImageEntity(
                medium = model.showModel.imageModel.medium,
                original = model.showModel.imageModel.original,
            ),
            scheduleEntity = ScheduleEntity(
                days = model.showModel.scheduleModel.days,
                time = model.showModel.scheduleModel.time
            ),
            genres = model.showModel.genres,
            summary = model.showModel.summary

        )
    )
}

internal fun toEntityList(initial: List<SearchResponseModel>): List<SearchResponseEntity> {
    return initial.map { toEntity(it) }
}
