package com.drodrigues.api_test.presentation.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.drodrigues.api_test.databinding.CardShowBinding
import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.presentation.view.listener.ShowCardClickListener
import com.squareup.picasso.Picasso

internal class ShowCardViewHolder(
    private val cardShowBinding: CardShowBinding,
    private val clickListener: ShowCardClickListener
) : RecyclerView.ViewHolder(cardShowBinding.root) {

    fun bindShow(showEntity: ShowEntity) {
        val imageUrl: String = showEntity.imageEntity.original
        Picasso.get().load(imageUrl).into(cardShowBinding.cardCover)
        cardShowBinding.cardTitle.text = showEntity.name

        cardShowBinding.showCardView.setOnClickListener {
            clickListener.onClick(showEntity)
        }
    }
}