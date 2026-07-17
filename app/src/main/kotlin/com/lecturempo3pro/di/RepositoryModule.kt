package com.lecturempo3pro.di

import com.lecturempo3pro.data.repository.SongRepositoryImpl
import com.lecturempo3pro.data.repository.PlaylistRepositoryImpl
import com.lecturempo3pro.domain.repository.SongRepository
import com.lecturempo3pro.domain.repository.PlaylistRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindSongRepository(
        songRepositoryImpl: SongRepositoryImpl
    ): SongRepository

    @Singleton
    @Binds
    abstract fun bindPlaylistRepository(
        playlistRepositoryImpl: PlaylistRepositoryImpl
    ): PlaylistRepository
}
