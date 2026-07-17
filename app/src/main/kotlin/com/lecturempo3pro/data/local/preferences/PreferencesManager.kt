package com.lecturempo3pro.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_preferences")

class PreferencesManager(private val context: Context) {
    companion object {
        private val THEME_KEY = stringPreferencesKey("theme")
        private val LANGUAGE_KEY = stringPreferencesKey("language")
        private val SHUFFLE_KEY = booleanPreferencesKey("shuffle")
        private val REPEAT_KEY = stringPreferencesKey("repeat")
        private val VOLUME_KEY = intPreferencesKey("volume")
        private val PLAYBACK_SPEED_KEY = intPreferencesKey("playback_speed")
        private val SHOW_NOTIFICATIONS_KEY = booleanPreferencesKey("show_notifications")
        private val CURRENT_SONG_ID_KEY = stringPreferencesKey("current_song_id")
        private val CURRENT_POSITION_KEY = longPreferencesKey("current_position")
        private val DYNAMIC_COLOR_KEY = booleanPreferencesKey("dynamic_color")
    }

    val theme: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[THEME_KEY] ?: "system"
    }

    val language: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[LANGUAGE_KEY] ?: "en"
    }

    val shuffle: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[SHUFFLE_KEY] ?: false
    }

    val repeat: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[REPEAT_KEY] ?: "repeat_all"
    }

    val volume: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[VOLUME_KEY] ?: 100
    }

    val playbackSpeed: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[PLAYBACK_SPEED_KEY] ?: 100
    }

    val showNotifications: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[SHOW_NOTIFICATIONS_KEY] ?: true
    }

    val currentSongId: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[CURRENT_SONG_ID_KEY]
    }

    val currentPosition: Flow<Long> = context.dataStore.data.map { preferences ->
        preferences[CURRENT_POSITION_KEY] ?: 0L
    }

    val dynamicColor: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[DYNAMIC_COLOR_KEY] ?: true
    }

    suspend fun setTheme(theme: String) {
        context.dataStore.edit { preferences ->
            preferences[THEME_KEY] = theme
        }
    }

    suspend fun setLanguage(language: String) {
        context.dataStore.edit { preferences ->
            preferences[LANGUAGE_KEY] = language
        }
    }

    suspend fun setShuffle(shuffle: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[SHUFFLE_KEY] = shuffle
        }
    }

    suspend fun setRepeat(repeat: String) {
        context.dataStore.edit { preferences ->
            preferences[REPEAT_KEY] = repeat
        }
    }

    suspend fun setVolume(volume: Int) {
        context.dataStore.edit { preferences ->
            preferences[VOLUME_KEY] = volume
        }
    }

    suspend fun setPlaybackSpeed(speed: Int) {
        context.dataStore.edit { preferences ->
            preferences[PLAYBACK_SPEED_KEY] = speed
        }
    }

    suspend fun setShowNotifications(show: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[SHOW_NOTIFICATIONS_KEY] = show
        }
    }

    suspend fun setCurrentSongId(songId: String?) {
        context.dataStore.edit { preferences ->
            if (songId == null) {
                preferences.remove(CURRENT_SONG_ID_KEY)
            } else {
                preferences[CURRENT_SONG_ID_KEY] = songId
            }
        }
    }

    suspend fun setCurrentPosition(position: Long) {
        context.dataStore.edit { preferences ->
            preferences[CURRENT_POSITION_KEY] = position
        }
    }

    suspend fun setDynamicColor(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[DYNAMIC_COLOR_KEY] = enabled
        }
    }
}
