package com.lecturempo3pro.domain.repository

import com.lecturempo3pro.domain.model.Song
import kotlinx.coroutines.flow.Flow

interface SongRepository {
    fun getAllSongs(): Flow<List<Song>>
    fun getFavoriteSongs(): Flow<List<Song>>
    fun getAllArtists(): Flow<List<String>>
    fun getAllAlbums(): Flow<List<String>>
    fun getAllGenres(): Flow<List<String>>
    fun getSongsByArtist(artist: String): Flow<List<Song>>
    fun getSongsByAlbum(album: String): Flow<List<Song>>
    fun getSongsByGenre(genre: String): Flow<List<Song>>
    fun getSongsByFolder(folderPath: String): Flow<List<Song>>
    fun getAllFolders(): Flow<List<String>>
    fun getSongById(songId: String): Flow<Song?>
    fun getSongCount(): Flow<Int>
    suspend fun insertSongs(songs: List<Song>)
    suspend fun insertSong(song: Song)
    suspend fun updateSong(song: Song)
    suspend fun deleteSong(song: Song)
    suspend fun deleteAllSongs()
    suspend fun toggleFavorite(songId: String, isFavorite: Boolean)
    suspend fun updatePlayCount(songId: String, timestamp: Long)
}
