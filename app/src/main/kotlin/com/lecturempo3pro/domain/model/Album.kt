package com.lecturempo3pro.domain.model

data class Album(
    val id: String,
    val name: String,
    val artist: String,
    val albumArt: String? = null,
    val songCount: Int = 0,
    val releaseYear: Int = 0
)
