package com.lecturempo3pro.domain.repository

import com.lecturempo3pro.domain.model.PlaylistSong
import kotlinx.coroutines.flow.Flow

interface PlaylistSongRepository {
    fun getPlaylistSongs(playlistId: Long): Flow<List<PlaylistSong>>
    fun getPlaylistSongCount(playlistId: Long): Flow<Int>
    suspend fun insertPlaylistSong(playlistSong: PlaylistSong)
    suspend fun insertPlaylistSongs(playlistSongs: List<PlaylistSong>)
    suspend fun deletePlaylistSong(playlistSong: PlaylistSong)
    suspend fun deletePlaylistSongs(playlistId: Long)
    suspend fun deleteAllPlaylistSongs()
}
