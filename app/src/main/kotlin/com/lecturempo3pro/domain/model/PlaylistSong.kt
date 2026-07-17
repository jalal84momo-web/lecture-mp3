package com.lecturempo3pro.domain.model

data class PlaylistSong(
    val id: Long,
    val playlistId: Long,
    val songId: String,
    val position: Int,
    val addedAt: Long
)
