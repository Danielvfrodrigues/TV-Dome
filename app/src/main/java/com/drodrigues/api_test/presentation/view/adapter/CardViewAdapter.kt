package com.drodrigues.api_test.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drodrigues.api_test.databinding.CardCellBinding
import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.presentation.view.listener.ShowCardClickListener
import com.drodrigues.api_test.presentation.view.viewholder.CardViewHolder

internal class CardViewAdapter(

    private val shows: List<ShowEntity>,
    private val clickListener: ShowCardClickListener

) : RecyclerView.Adapter<CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from, parent, false)

        return CardViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindShow(shows[position])
    }

    override fun getItemCount(): Int = shows.size
}