package com.drodrigues.tvdome.presentation.view.listener

import com.drodrigues.tvdome.domain.entity.SeasonEntity

internal interface SeasonCardClickListener {
    fun onClick(seasonEntity: SeasonEntity)
}