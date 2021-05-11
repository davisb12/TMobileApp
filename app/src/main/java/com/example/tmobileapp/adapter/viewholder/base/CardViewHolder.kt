package com.example.tmobileapp.adapter.viewholder.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.tmobileapp.model.Card

abstract class CardViewHolder(
    binding: ViewBinding,
    var cardClicked: ((Int) -> Unit)? = null
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener { cardClicked?.invoke(adapterPosition) }
    }

    abstract fun bind(card: Card)

}