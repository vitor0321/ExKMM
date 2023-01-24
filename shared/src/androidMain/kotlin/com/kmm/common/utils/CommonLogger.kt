package com.kmm.common.utils

import android.util.Log
import com.kmm.todo.BuildConfig

actual interface CommonLogger {

    actual fun log(message: String) {
        if (BuildConfig.DEBUG) {
            Log.d(BuildConfig.BUILD_TYPE, message)
        }
    }
}