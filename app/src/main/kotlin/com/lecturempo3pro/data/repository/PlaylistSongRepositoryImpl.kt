package com.lecturempo3pro.data.repository

import com.lecturempo3pro.data.local.dao.PlaylistSongDao
import com.lecturempo3pro.data.local.entity.PlaylistSongEntity
import com.lecturempo3pro.domain.model.PlaylistSong
import com.lecturempo3pro.domain.repository.PlaylistSongRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlaylistSongRepositoryImpl @Inject constructor(
    private val playlistSongDao: PlaylistSongDao
) : PlaylistSongRepository {
    override fun getPlaylistSongs(playlistId: Long): Flow<List<PlaylistSong>> =
        playlistSongDao.getPlaylistSongs(playlistId).map { entities -> entities.map { it.toDomain() } }

    override fun getPlaylistSongCount(playlistId: Long): Flow<Int> =
        playlistSongDao.getPlaylistSongCount(playlistId)

    override suspend fun insertPlaylistSong(playlistSong: PlaylistSong) =
        playlistSongDao.insertPlaylistSong(playlistSong.toEntity())

    override suspend fun insertPlaylistSongs(playlistSongs: List<PlaylistSong>) =
        playlistSongDao.insertPlaylistSongs(playlistSongs.map { it.toEntity() })

    override suspend fun deletePlaylistSong(playlistSong: PlaylistSong) =
        playlistSongDao.deletePlaylistSong(playlistSong.toEntity())

    override suspend fun deletePlaylistSongs(playlistId: Long) =
        playlistSongDao.deletePlaylistSongs(playlistId)

    override suspend fun deleteAllPlaylistSongs() =
        playlistSongDao.deleteAllPlaylistSongs()

    private fun PlaylistSongEntity.toDomain() = PlaylistSong(
        id = id,
        playlistId = playlistId,
        songId = songId,
        position = position,
        addedAt = addedAt
    )

    private fun PlaylistSong.toEntity() = PlaylistSongEntity(
        id = id,
        playlistId = playlistId,
        songId = songId,
        position = position,
        addedAt = addedAt
    )
}
