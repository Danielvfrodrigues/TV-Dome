package com.drodrigues.tvdome.presentation.view.listener

import com.drodrigues.tvdome.domain.entity.EpisodeEntity

internal interface EpisodeCardClickListener {
    fun onClick(episodeEntity: EpisodeEntity)
}