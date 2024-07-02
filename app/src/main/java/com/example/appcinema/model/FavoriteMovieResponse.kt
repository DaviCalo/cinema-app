package com.example.appcinema.model

import kotlinx.serialization.Serializable

@Serializable
class FavoriteResponse(
    val success: Boolean,
    val status_code: Int,
    val status_message: String
)