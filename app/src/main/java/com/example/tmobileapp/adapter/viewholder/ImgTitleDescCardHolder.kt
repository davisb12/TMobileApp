package com.example.tmobileapp.adapter.viewholder

import android.view.ViewGroup
import com.example.tmobileapp.adapter.viewholder.base.CardViewHolder
import com.example.tmobileapp.databinding.ImgTitleDescItemBinding
import com.example.tmobileapp.model.Card
import com.example.tmobileapp.util.CardText
import com.example.tmobileapp.util.inflater
import com.example.tmobileapp.util.loadUrl
import com.example.tmobileapp.util.setTextCard

class ImgTitleDescCardHolder(
    private val binding: ImgTitleDescItemBinding
) : CardViewHolder(binding) {

    override fun bind(card: Card) = with(binding) {
        tvTitle.setTextCard(card, CardText.TITLE)
        tvDescription.setTextCard(card, CardText.DESCRIPTION)
        ivBackground.loadUrl(card)
    }

    companion object {
        fun create(parent: ViewGroup) = ImgTitleDescCardHolder(
            ImgTitleDescItemBinding.inflate(parent.inflater, parent, false)
        )
    }
}