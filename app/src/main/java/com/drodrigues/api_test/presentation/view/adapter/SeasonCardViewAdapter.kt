package com.drodrigues.api_test.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drodrigues.api_test.databinding.CardSeasonBinding
import com.drodrigues.api_test.domain.entity.SeasonEntity
import com.drodrigues.api_test.presentation.view.listener.SeasonCardClickListener
import com.drodrigues.api_test.presentation.view.viewholder.SeasonCardViewHolder

internal class SeasonCardViewAdapter(

    private val seasons: List<SeasonEntity>,
    private val clickListener: SeasonCardClickListener

) : RecyclerView.Adapter<SeasonCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonCardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardSeasonBinding.inflate(from, parent, false)

        return SeasonCardViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: SeasonCardViewHolder, position: Int) {
        holder.bindSeason(seasons[position])
    }

    override fun getItemCount(): Int = seasons.size
}
