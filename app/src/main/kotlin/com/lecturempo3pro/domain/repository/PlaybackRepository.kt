package com.lecturempo3pro.domain.repository

import com.lecturempo3pro.domain.model.PlaybackState
import kotlinx.coroutines.flow.Flow

interface PlaybackRepository {
    fun getPlaybackState(): Flow<PlaybackState>
    suspend fun savePlaybackState(state: PlaybackState)
    suspend fun clearPlaybackState()
}
