package com.drodrigues.tvdome.presentation.view.viewholder

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.drodrigues.tvdome.databinding.CardShowBinding
import com.drodrigues.tvdome.domain.entity.EpisodeEntity
import com.drodrigues.tvdome.presentation.view.listener.EpisodeCardClickListener
import com.squareup.picasso.Picasso

internal class EpisodeCardViewHolder(
    private val cardShowBinding: CardShowBinding,
    private val clickListener: EpisodeCardClickListener
) : RecyclerView.ViewHolder(cardShowBinding.root) {

    @SuppressLint("SetTextI18n")
    fun bindShow(episodeEntity: EpisodeEntity) {
        val imageUrl: String = episodeEntity.imageEntity.original
        Picasso.get().load(imageUrl).into(cardShowBinding.cardCover)
        cardShowBinding.cardTitle.text = episodeEntity.name
        cardShowBinding.cardDescription.text = "Episode ${episodeEntity.number}"
        cardShowBinding.showCardView.setOnClickListener {
            clickListener.onClick(episodeEntity)
        }
    }
}