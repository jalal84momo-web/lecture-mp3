package com.lecturempo3pro.di

import android.content.Context
import com.lecturempo3pro.data.local.preferences.PreferencesManager
import com.lecturempo3pro.presentation.MediaScanner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilityModule {
    @Singleton
    @Provides
    fun provideMediaScanner(@ApplicationContext context: Context): MediaScanner =
        MediaScanner(context)
}
