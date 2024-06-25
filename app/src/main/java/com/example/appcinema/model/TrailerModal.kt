package com.example.appcinema.model

import kotlinx.serialization.Serializable

@Serializable
data class TrailerModal(
    val results: List<VideoModal>
)

@Serializable
data class VideoModal(
    val name: String,
    val key: String,
    val type: String
)