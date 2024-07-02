package com.example.appcinema.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseAllCards(
    val results: List<CardModel>
)
