package com.drodrigues.tvdome.presentation.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.drodrigues.tvdome.databinding.CardSeasonBinding
import com.drodrigues.tvdome.domain.entity.SeasonEntity
import com.drodrigues.tvdome.presentation.view.listener.SeasonCardClickListener

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