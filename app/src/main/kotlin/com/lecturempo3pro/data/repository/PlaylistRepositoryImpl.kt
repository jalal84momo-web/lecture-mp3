package com.lecturempo3pro.data.repository

import com.lecturempo3pro.data.local.dao.PlaylistDao
import com.lecturempo3pro.data.local.entity.PlaylistEntity
import com.lecturempo3pro.domain.model.Playlist
import com.lecturempo3pro.domain.repository.PlaylistRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlaylistRepositoryImpl @Inject constructor(
    private val playlistDao: PlaylistDao
) : PlaylistRepository {
    override fun getAllPlaylists(): Flow<List<Playlist>> =
        playlistDao.getAllPlaylists().map { entities -> entities.map { it.toDomain() } }

    override fun getPlaylistById(playlistId: Long): Flow<Playlist?> =
        playlistDao.getPlaylistById(playlistId).map { it?.toDomain() }

    override fun getPlaylistCount(): Flow<Int> = playlistDao.getPlaylistCount()

    override suspend fun insertPlaylist(playlist: Playlist): Long =
        playlistDao.insertPlaylist(playlist.toEntity())

    override suspend fun updatePlaylist(playlist: Playlist) =
        playlistDao.updatePlaylist(playlist.toEntity())

    override suspend fun deletePlaylist(playlist: Playlist) =
        playlistDao.deletePlaylist(playlist.toEntity())

    override suspend fun deleteAllPlaylists() = playlistDao.deleteAllPlaylists()

    private fun PlaylistEntity.toDomain() = Playlist(
        id = id,
        name = name,
        description = description,
        createdAt = createdAt,
        modifiedAt = modifiedAt,
        songCount = songCount
    )

    private fun Playlist.toEntity() = PlaylistEntity(
        id = id,
        name = name,
        description = description,
        createdAt = createdAt,
        modifiedAt = modifiedAt,
        songCount = songCount
    )
}
