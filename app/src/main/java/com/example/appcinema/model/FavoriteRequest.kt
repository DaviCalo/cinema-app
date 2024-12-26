package com.example.appcinema.model

import kotlinx.serialization.Serializable

@Serializable
data class FavoriteRequest(
    val media_id: Int,
    val media_type: String,
    val favorite: Boolean
)