package com.example.tmobileapp.adapter.viewholder

import android.view.ViewGroup
import com.example.tmobileapp.adapter.viewholder.base.CardViewHolder
import com.example.tmobileapp.databinding.TextItemBinding
import com.example.tmobileapp.model.Card
import com.example.tmobileapp.util.CardText
import com.example.tmobileapp.util.inflater
import com.example.tmobileapp.util.setTextCard

class TextCardHolder(private val binding: TextItemBinding) : CardViewHolder(binding) {

    override fun bind(card: Card) = with(binding) { tvValue.setTextCard(card, CardText.VALUE) }

    companion object {
        fun create(parent: ViewGroup) = TextCardHolder(
            TextItemBinding.inflate(parent.inflater, parent, false)
        )
    }
}