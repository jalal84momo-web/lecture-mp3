package com.lecturempo3pro.util

import timber.log.Timber

object Logger {
    fun d(tag: String, message: String) {
        Timber.tag(tag).d(message)
    }

    fun e(tag: String, message: String, throwable: Throwable? = null) {
        if (throwable != null) {
            Timber.tag(tag).e(throwable, message)
        } else {
            Timber.tag(tag).e(message)
        }
    }

    fun w(tag: String, message: String) {
        Timber.tag(tag).w(message)
    }
}
