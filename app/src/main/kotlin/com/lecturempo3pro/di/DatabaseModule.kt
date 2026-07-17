package com.lecturempo3pro.di

import android.content.Context
import androidx.room.Room
import com.lecturempo3pro.data.local.database.LectureDatabase
import com.lecturempo3pro.data.local.dao.SongDao
import com.lecturempo3pro.data.local.dao.PlaylistDao
import com.lecturempo3pro.data.local.dao.PlaylistSongDao
import com.lecturempo3pro.data.local.dao.RecentlyPlayedDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): LectureDatabase {
        return LectureDatabase.getDatabase(context)
    }

    @Singleton
    @Provides
    fun provideSongDao(database: LectureDatabase): SongDao = database.songDao()

    @Singleton
    @Provides
    fun providePlaylistDao(database: LectureDatabase): PlaylistDao = database.playlistDao()

    @Singleton
    @Provides
    fun providePlaylistSongDao(database: LectureDatabase): PlaylistSongDao = database.playlistSongDao()

    @Singleton
    @Provides
    fun provideRecentlyPlayedDao(database: LectureDatabase): RecentlyPlayedDao = database.recentlyPlayedDao()
}
