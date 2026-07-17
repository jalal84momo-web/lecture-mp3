package com.lecturempo3pro.domain.model

data class RecentlyPlayed(
    val songId: String,
    val lastPlayedAt: Long,
    val playCount: Int = 1
)
