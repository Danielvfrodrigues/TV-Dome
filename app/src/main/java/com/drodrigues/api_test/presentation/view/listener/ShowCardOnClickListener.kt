package com.drodrigues.tvdome.presentation.view.listener

import com.drodrigues.tvdome.domain.entity.ShowEntity

internal interface ShowCardOnClickListener {
    fun onClick(showEntity: ShowEntity)
}