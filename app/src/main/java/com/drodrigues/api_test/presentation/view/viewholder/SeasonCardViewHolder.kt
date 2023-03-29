package com.drodrigues.api_test.presentation.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.drodrigues.api_test.databinding.CardSeasonBinding
import com.drodrigues.api_test.domain.entity.SeasonEntity
import com.drodrigues.api_test.presentation.view.listener.SeasonCardClickListener

internal class SeasonCardViewHolder(
    private val cardSeasonBinding: CardSeasonBinding,
    private val clickListener: SeasonCardClickListener
) : RecyclerView.ViewHolder(cardSeasonBinding.root) {

    fun bindSeason(seasonEntity: SeasonEntity) {
        cardSeasonBinding.seasonNumber.text = seasonEntity.number
        cardSeasonBinding.episodeOrderTextView.text = seasonEntity.episodeOrder
        cardSeasonBinding.seasonCardView.setOnClickListener {
            clickListener.onClick(seasonEntity)
        }
    }
}