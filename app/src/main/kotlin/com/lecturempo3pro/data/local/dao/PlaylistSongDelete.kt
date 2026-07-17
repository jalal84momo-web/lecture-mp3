package com.lecturempo3pro.data.local.dao

import androidx.room.Delete
import androidx.room.Entity

// Fix for PlaylistSongDao to support Delete operation
@Entity(tableName = "playlist_songs")
data class PlaylistSongDeleteEntity(
    val id: Long = 0
)
