package com.drodrigues.api_test.presentation.view.listener

import com.drodrigues.api_test.domain.entity.SeasonEntity

internal interface SeasonCardClickListener {
    fun onClick(seasonEntity: SeasonEntity)
}