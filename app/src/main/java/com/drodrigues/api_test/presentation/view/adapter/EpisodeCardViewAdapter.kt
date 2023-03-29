package com.drodrigues.api_test.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drodrigues.api_test.databinding.CardShowBinding
import com.drodrigues.api_test.domain.entity.EpisodeEntity
import com.drodrigues.api_test.presentation.view.listener.EpisodeCardClickListener
import com.drodrigues.api_test.presentation.view.viewholder.EpisodeCardViewHolder

internal class EpisodeCardViewAdapter(

    private val episodes: List<EpisodeEntity>,
    private val clickListener: EpisodeCardClickListener

) : RecyclerView.Adapter<EpisodeCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeCardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardShowBinding.inflate(from, parent, false)

        return EpisodeCardViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: EpisodeCardViewHolder, position: Int) {
        holder.bindShow(episodes[position])
    }

    override fun getItemCount(): Int = episodes.size
}