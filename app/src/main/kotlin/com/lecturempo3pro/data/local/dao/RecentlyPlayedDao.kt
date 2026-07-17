package com.lecturempo3pro.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.lecturempo3pro.data.local.entity.RecentlyPlayedEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecentlyPlayedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecentlyPlayed(recentlyPlayed: RecentlyPlayedEntity)

    @Update
    suspend fun updateRecentlyPlayed(recentlyPlayed: RecentlyPlayedEntity)

    @Delete
    suspend fun deleteRecentlyPlayed(recentlyPlayed: RecentlyPlayedEntity)

    @Query("SELECT * FROM recently_played ORDER BY last_played_at DESC LIMIT :limit")
    fun getRecentlyPlayed(limit: Int = 50): Flow<List<RecentlyPlayedEntity>>

    @Query("DELETE FROM recently_played")
    suspend fun deleteAllRecentlyPlayed()
}
