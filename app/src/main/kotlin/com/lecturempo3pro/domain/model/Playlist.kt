package com.lecturempo3pro.domain.model

data class Playlist(
    val id: Long,
    val name: String,
    val description: String = "",
    val createdAt: Long,
    val modifiedAt: Long,
    val songCount: Int = 0
)
