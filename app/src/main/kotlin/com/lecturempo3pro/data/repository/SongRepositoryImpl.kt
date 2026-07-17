package com.lecturempo3pro.data.repository

import com.lecturempo3pro.data.local.dao.SongDao
import com.lecturempo3pro.data.local.entity.SongEntity
import com.lecturempo3pro.domain.model.Song
import com.lecturempo3pro.domain.repository.SongRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SongRepositoryImpl @Inject constructor(
    private val songDao: SongDao
) : SongRepository {
    override fun getAllSongs(): Flow<List<Song>> =
        songDao.getAllSongs().map { entities -> entities.map { it.toDomain() } }

    override fun getFavoriteSongs(): Flow<List<Song>> =
        songDao.getFavoriteSongs().map { entities -> entities.map { it.toDomain() } }

    override fun getAllArtists(): Flow<List<String>> = songDao.getAllArtists()

    override fun getAllAlbums(): Flow<List<String>> = songDao.getAllAlbums()

    override fun getAllGenres(): Flow<List<String>> = songDao.getAllGenres()

    override fun getSongsByArtist(artist: String): Flow<List<Song>> =
        songDao.getSongsByArtist(artist).map { entities -> entities.map { it.toDomain() } }

    override fun getSongsByAlbum(album: String): Flow<List<Song>> =
        songDao.getSongsByAlbum(album).map { entities -> entities.map { it.toDomain() } }

    override fun getSongsByGenre(genre: String): Flow<List<Song>> =
        songDao.getSongsByGenre(genre).map { entities -> entities.map { it.toDomain() } }

    override fun getSongsByFolder(folderPath: String): Flow<List<Song>> =
        songDao.getSongsByFolder(folderPath).map { entities -> entities.map { it.toDomain() } }

    override fun getAllFolders(): Flow<List<String>> = songDao.getAllFolders()

    override fun getSongById(songId: String): Flow<Song?> =
        songDao.getSongById(songId).map { it?.toDomain() }

    override fun getSongCount(): Flow<Int> = songDao.getSongCount()

    override suspend fun insertSongs(songs: List<Song>) =
        songDao.insertSongs(songs.map { it.toEntity() })

    override suspend fun insertSong(song: Song) =
        songDao.insertSong(song.toEntity())

    override suspend fun updateSong(song: Song) =
        songDao.updateSong(song.toEntity())

    override suspend fun deleteSong(song: Song) =
        songDao.deleteSong(song.toEntity())

    override suspend fun deleteAllSongs() = songDao.deleteAllSongs()

    override suspend fun toggleFavorite(songId: String, isFavorite: Boolean) =
        songDao.toggleFavorite(songId, isFavorite)

    override suspend fun updatePlayCount(songId: String, timestamp: Long) =
        songDao.updatePlayCount(songId, timestamp)

    private fun SongEntity.toDomain() = Song(
        id = id,
        title = title,
        artist = artist,
        album = album,
        genre = genre,
        path = path,
        duration = duration,
        size = size,
        dateAdded = dateAdded,
        dateModified = dateModified,
        albumArt = albumArt,
        isFavorite = isFavorite,
        playCount = playCount,
        lastPlayed = lastPlayed,
        folderPath = folderPath
    )

    private fun Song.toEntity() = SongEntity(
        id = id,
        title = title,
        artist = artist,
        album = album,
        genre = genre,
        path = path,
        duration = duration,
        size = size,
        dateAdded = dateAdded,
        dateModified = dateModified,
        albumArt = albumArt,
        isFavorite = isFavorite,
        playCount = playCount,
        lastPlayed = lastPlayed,
        folderPath = folderPath
    )
}
