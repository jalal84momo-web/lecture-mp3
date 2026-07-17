package com.lecturempo3pro.domain.usecase

import com.lecturempo3pro.domain.model.RecentlyPlayed
import com.lecturempo3pro.domain.repository.RecentlyPlayedRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecentlyPlayedUseCase @Inject constructor(
    private val recentlyPlayedRepository: RecentlyPlayedRepository
) {
    operator fun invoke(limit: Int = 50): Flow<List<RecentlyPlayed>> =
        recentlyPlayedRepository.getRecentlyPlayed(limit)
}

class AddToRecentlyPlayedUseCase @Inject constructor(
    private val recentlyPlayedRepository: RecentlyPlayedRepository
) {
    suspend operator fun invoke(recentlyPlayed: RecentlyPlayed) =
        recentlyPlayedRepository.insertRecentlyPlayed(recentlyPlayed)
}
