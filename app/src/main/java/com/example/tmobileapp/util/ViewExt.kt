package com.example.tmobileapp.util

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.tmobileapp.model.Attributes
import com.example.tmobileapp.model.Card
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

val ViewGroup.inflater: LayoutInflater
    get() = LayoutInflater.from(context)

fun MaterialTextView.setTextColor(color: String) = setTextColor(Color.parseColor(color))

fun MaterialTextView.setAttributes(attributes: Attributes) {
    attributes.font?.size?.let { textSize = it.toFloat() }
    attributes.textColor?.let { setTextColor(it) }
}

enum class CardText {
    VALUE, TITLE, DESCRIPTION
}

fun MaterialTextView.setTextCard(card: Card, cardText: CardText) {
    val pair : Pair<String?, Attributes?> = when (cardText) {
        CardText.VALUE -> card.value to card.attributes
        CardText.TITLE -> card.title?.value to card.title?.attributes
        CardText.DESCRIPTION -> card.description?.value to card.title?.attributes
    }
    text = pair.first ?: ""
    pair.second?.let { setAttributes(it) }
}

fun ShapeableImageView.loadUrl(card: Card) {
    Glide.with(context).load(card.image?.url).into(this)
    layoutParams.apply {
        card.image?.size?.width?.let { width = it }
        card.image?.size?.height?.let { height = it }
    }
}