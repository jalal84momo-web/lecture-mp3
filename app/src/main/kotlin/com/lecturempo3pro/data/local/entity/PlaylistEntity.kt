package com.lecturempo3pro.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playlists")
data class PlaylistEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String = "",
    @ColumnInfo(name = "created_at")
    val createdAt: Long,
    @ColumnInfo(name = "modified_at")
    val modifiedAt: Long,
    @ColumnInfo(name = "song_count")
    val songCount: Int = 0
)
