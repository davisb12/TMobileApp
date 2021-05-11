package com.example.tmobileapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmobileapp.adapter.viewholder.base.CardViewHolder
import com.example.tmobileapp.adapter.viewholder.ImgTitleDescCardHolder
import com.example.tmobileapp.adapter.viewholder.TextCardHolder
import com.example.tmobileapp.adapter.viewholder.TitleDescCardHolder
import com.example.tmobileapp.model.CardHolder
import com.example.tmobileapp.util.CardType.*

class CardsAdapter(
        cards: List<CardHolder>,
        private val cardClickListener: (CardHolder) -> Unit
) : RecyclerView.Adapter<CardViewHolder>() {

    private val nonNullCards = cards.filter { it.card != null }

    override fun onCreateViewHolder(
            parent: ViewGroup, viewType: Int
    ) = when (viewType) {
        TEXT.ordinal -> TextCardHolder.create(parent)
        TITLE_DESCRIPTION.ordinal -> TitleDescCardHolder.create(parent)
        else -> ImgTitleDescCardHolder.create(parent)
    }.apply { cardClicked = { index -> cardClickListener.invoke(nonNullCards[index]) } }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(nonNullCards[position].card!!)
    }

    override fun getItemViewType(position: Int) =
            when (val type = nonNullCards[position].cardType) {
                TEXT, TITLE_DESCRIPTION, IMAGE_TITLE_DESCRIPTION -> type.ordinal
                else -> -1
            }

    override fun getItemCount() = nonNullCards.size

}