package com.lecturempo3pro.presentation.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import timber.log.Timber

class HeadsetPlugReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_HEADSET_PLUG) {
            val state = intent.getIntExtra("state", -1)
            when (state) {
                0 -> Timber.d("Headset unplugged")
                1 -> Timber.d("Headset plugged")
            }
        }
    }
}
