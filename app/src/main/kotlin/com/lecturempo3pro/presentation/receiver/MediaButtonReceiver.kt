package com.lecturempo3pro.presentation.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.view.KeyEvent
import timber.log.Timber

class MediaButtonReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_MEDIA_BUTTON) {
            val keyEvent = intent.getParcelableExtra<KeyEvent>(Intent.EXTRA_KEY_EVENT)
            if (keyEvent != null && keyEvent.action == KeyEvent.ACTION_DOWN) {
                when (keyEvent.keyCode) {
                    KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE -> Timber.d("Play/Pause pressed")
                    KeyEvent.KEYCODE_MEDIA_NEXT -> Timber.d("Next pressed")
                    KeyEvent.KEYCODE_MEDIA_PREVIOUS -> Timber.d("Previous pressed")
                }
            }
        }
    }
}
