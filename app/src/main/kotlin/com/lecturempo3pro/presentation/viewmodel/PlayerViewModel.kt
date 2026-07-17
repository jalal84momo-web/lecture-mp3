package com.lecturempo3pro.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.lecturempo3pro.domain.model.PlaybackState
import com.lecturempo3pro.domain.model.RepeatMode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor() : ViewModel() {
    private val _playbackState = MutableStateFlow(
        PlaybackState()
    )
    val playbackState = _playbackState.asStateFlow()

    fun play() {
        viewModelScope.launch {
            _playbackState.value = _playbackState.value.copy(isPlaying = true)
        }
    }

    fun pause() {
        viewModelScope.launch {
            _playbackState.value = _playbackState.value.copy(isPlaying = false)
        }
    }

    fun toggleRepeatMode() {
        viewModelScope.launch {
            val currentMode = _playbackState.value.repeatMode
            val newMode = when (currentMode) {
                RepeatMode.REPEAT_ALL -> RepeatMode.REPEAT_ONE
                RepeatMode.REPEAT_ONE -> RepeatMode.REPEAT_OFF
                RepeatMode.REPEAT_OFF -> RepeatMode.REPEAT_ALL
            }
            _playbackState.value = _playbackState.value.copy(repeatMode = newMode)
        }
    }

    fun toggleShuffle() {
        viewModelScope.launch {
            val current = _playbackState.value.isShuffleEnabled
            _playbackState.value = _playbackState.value.copy(isShuffleEnabled = !current)
        }
    }
}
