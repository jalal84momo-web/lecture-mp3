package com.lecturempo3pro.domain.repository

import com.lecturempo3pro.domain.model.RecentlyPlayed
import kotlinx.coroutines.flow.Flow

interface RecentlyPlayedRepository {
    fun getRecentlyPlayed(limit: Int = 50): Flow<List<RecentlyPlayed>>
    suspend fun insertRecentlyPlayed(recentlyPlayed: RecentlyPlayed)
    suspend fun updateRecentlyPlayed(recentlyPlayed: RecentlyPlayed)
    suspend fun deleteRecentlyPlayed(recentlyPlayed: RecentlyPlayed)
    suspend fun deleteAllRecentlyPlayed()
}
