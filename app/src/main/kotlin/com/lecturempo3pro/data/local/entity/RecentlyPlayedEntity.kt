package com.lecturempo3pro.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recently_played")
data class RecentlyPlayedEntity(
    @PrimaryKey
    @ColumnInfo(name = "song_id")
    val songId: String,
    @ColumnInfo(name = "last_played_at")
    val lastPlayedAt: Long,
    @ColumnInfo(name = "play_count")
    val playCount: Int = 1
)
