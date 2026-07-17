package com.lecturempo3pro.data.repository

import com.lecturempo3pro.data.local.dao.RecentlyPlayedDao
import com.lecturempo3pro.data.local.entity.RecentlyPlayedEntity
import com.lecturempo3pro.domain.model.RecentlyPlayed
import com.lecturempo3pro.domain.repository.RecentlyPlayedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RecentlyPlayedRepositoryImpl @Inject constructor(
    private val recentlyPlayedDao: RecentlyPlayedDao
) : RecentlyPlayedRepository {
    override fun getRecentlyPlayed(limit: Int): Flow<List<RecentlyPlayed>> =
        recentlyPlayedDao.getRecentlyPlayed(limit).map { entities -> entities.map { it.toDomain() } }

    override suspend fun insertRecentlyPlayed(recentlyPlayed: RecentlyPlayed) =
        recentlyPlayedDao.insertRecentlyPlayed(recentlyPlayed.toEntity())

    override suspend fun updateRecentlyPlayed(recentlyPlayed: RecentlyPlayed) =
        recentlyPlayedDao.updateRecentlyPlayed(recentlyPlayed.toEntity())

    override suspend fun deleteRecentlyPlayed(recentlyPlayed: RecentlyPlayed) =
        recentlyPlayedDao.deleteRecentlyPlayed(recentlyPlayed.toEntity())

    override suspend fun deleteAllRecentlyPlayed() =
        recentlyPlayedDao.deleteAllRecentlyPlayed()

    private fun RecentlyPlayedEntity.toDomain() = RecentlyPlayed(
        songId = songId,
        lastPlayedAt = lastPlayedAt,
        playCount = playCount
    )

    private fun RecentlyPlayed.toEntity() = RecentlyPlayedEntity(
        songId = songId,
        lastPlayedAt = lastPlayedAt,
        playCount = playCount
    )
}
