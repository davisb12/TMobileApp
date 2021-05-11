package com.example.tmobileapp.adapter.viewholder

import android.view.ViewGroup
import com.example.tmobileapp.adapter.viewholder.base.CardViewHolder
import com.example.tmobileapp.databinding.TitleDescItemBinding
import com.example.tmobileapp.model.Card
import com.example.tmobileapp.util.CardText
import com.example.tmobileapp.util.inflater
import com.example.tmobileapp.util.setTextCard

class TitleDescCardHolder(private val binding: TitleDescItemBinding) : CardViewHolder(binding) {

    override fun bind(card: Card) = with(binding) {
        tvTitle.setTextCard(card, CardText.TITLE)
        tvDescription.setTextCard(card, CardText.DESCRIPTION)
    }

    companion object {
        fun create(parent: ViewGroup) = TitleDescCardHolder(
            TitleDescItemBinding.inflate(parent.inflater, parent, false)
        )
    }
}