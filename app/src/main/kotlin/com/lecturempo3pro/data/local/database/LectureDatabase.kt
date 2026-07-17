package com.lecturempo3pro.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lecturempo3pro.data.local.dao.PlaylistDao
import com.lecturempo3pro.data.local.dao.PlaylistSongDao
import com.lecturempo3pro.data.local.dao.RecentlyPlayedDao
import com.lecturempo3pro.data.local.dao.SongDao
import com.lecturempo3pro.data.local.entity.PlaylistEntity
import com.lecturempo3pro.data.local.entity.PlaylistSongEntity
import com.lecturempo3pro.data.local.entity.RecentlyPlayedEntity
import com.lecturempo3pro.data.local.entity.SongEntity

@Database(
    entities = [
        SongEntity::class,
        PlaylistEntity::class,
        PlaylistSongEntity::class,
        RecentlyPlayedEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class LectureDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao
    abstract fun playlistDao(): PlaylistDao
    abstract fun playlistSongDao(): PlaylistSongDao
    abstract fun recentlyPlayedDao(): RecentlyPlayedDao

    companion object {
        private const val DB_NAME = "lecture_mp3_pro.db"

        fun getDatabase(context: Context): LectureDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                LectureDatabase::class.java,
                DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
