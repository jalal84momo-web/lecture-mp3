package com.lecturempo3pro.domain.model

data class PlaybackState(
    val currentSongId: String? = null,
    val isPlaying: Boolean = false,
    val currentPosition: Long = 0L,
    val duration: Long = 0L,
    val repeatMode: RepeatMode = RepeatMode.REPEAT_ALL,
    val isShuffleEnabled: Boolean = false,
    val queue: List<String> = emptyList(),
    val currentQueueIndex: Int = 0
)

enum class RepeatMode {
    REPEAT_ALL,
    REPEAT_ONE,
    REPEAT_OFF
}
