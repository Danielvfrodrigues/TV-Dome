package com.drodrigues.api_test.presentation.view.viewholder

import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.drodrigues.api_test.databinding.CardCellBinding
import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.presentation.view.listener.ShowCardClickListener
import com.squareup.picasso.Picasso

internal class CardViewHolder(
    private val cardCellBinding: CardCellBinding, 
    private val clickListener: ShowCardClickListener
) : RecyclerView.ViewHolder(cardCellBinding  .root) {

    fun bindShow(showEntity: ShowEntity) {
        val imageUrl: String = showEntity.imageEntity.original
        Picasso.get().load(imageUrl).into(cardCellBinding.cardCover)
        cardCellBinding.cardTitle.text = showEntity.name

        cardCellBinding.showCardView.setOnClickListener {
            clickListener.onClick(showEntity)
        }
    }
}