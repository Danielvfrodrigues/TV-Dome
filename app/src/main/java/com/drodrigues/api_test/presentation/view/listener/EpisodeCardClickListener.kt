package com.drodrigues.api_test.presentation.view.listener

import com.drodrigues.api_test.domain.entity.EpisodeEntity

internal interface EpisodeCardClickListener {
    fun onClick(episodeEntity: EpisodeEntity)
}