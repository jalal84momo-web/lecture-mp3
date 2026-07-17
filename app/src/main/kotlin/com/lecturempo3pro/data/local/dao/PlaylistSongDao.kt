package com.lecturempo3pro.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lecturempo3pro.data.local.entity.PlaylistSongEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaylistSongDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaylistSong(playlistSong: PlaylistSongEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaylistSongs(playlistSongs: List<PlaylistSongEntity>)

    @Delete
    suspend fun deletePlaylistSong(playlistSong: PlaylistSongEntity)

    @Query("SELECT * FROM playlist_songs WHERE playlist_id = :playlistId ORDER BY position ASC")
    fun getPlaylistSongs(playlistId: Long): Flow<List<PlaylistSongEntity>>

    @Query("SELECT COUNT(*) FROM playlist_songs WHERE playlist_id = :playlistId")
    fun getPlaylistSongCount(playlistId: Long): Flow<Int>

    @Query("DELETE FROM playlist_songs WHERE playlist_id = :playlistId")
    suspend fun deletePlaylistSongs(playlistId: Long)

    @Query("DELETE FROM playlist_songs")
    suspend fun deleteAllPlaylistSongs()
}
