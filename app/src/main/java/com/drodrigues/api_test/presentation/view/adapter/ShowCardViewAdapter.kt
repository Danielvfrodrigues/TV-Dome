package com.drodrigues.api_test.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drodrigues.api_test.databinding.CardShowBinding
import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.presentation.view.listener.ShowCardOnClickListener
import com.drodrigues.api_test.presentation.view.viewholder.ShowCardViewHolder

internal class ShowCardViewAdapter(

    private val shows: List<ShowEntity>,
    private val clickListener: ShowCardOnClickListener

) : RecyclerView.Adapter<ShowCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardShowBinding.inflate(from, parent, false)

        return ShowCardViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: ShowCardViewHolder, position: Int) {
        holder.bindShow(shows[position])
    }

    override fun getItemCount(): Int = shows.size
}