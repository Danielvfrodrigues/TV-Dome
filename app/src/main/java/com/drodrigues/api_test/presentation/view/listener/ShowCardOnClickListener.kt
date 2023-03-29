package com.drodrigues.api_test.presentation.view.listener

import com.drodrigues.api_test.domain.entity.ShowEntity

internal interface ShowCardOnClickListener {
    fun onClick(showEntity: ShowEntity)
}