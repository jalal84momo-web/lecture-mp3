package com.lecturempo3pro.di

import com.lecturempo3pro.data.repository.PlaylistSongRepositoryImpl
import com.lecturempo3pro.data.repository.RecentlyPlayedRepositoryImpl
import com.lecturempo3pro.domain.repository.PlaylistSongRepository
import com.lecturempo3pro.domain.repository.RecentlyPlayedRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AdditionalRepositoryModule {
    @Singleton
    @Binds
    abstract fun bindPlaylistSongRepository(
        playlistSongRepositoryImpl: PlaylistSongRepositoryImpl
    ): PlaylistSongRepository

    @Singleton
    @Binds
    abstract fun bindRecentlyPlayedRepository(
        recentlyPlayedRepositoryImpl: RecentlyPlayedRepositoryImpl
    ): RecentlyPlayedRepository
}
