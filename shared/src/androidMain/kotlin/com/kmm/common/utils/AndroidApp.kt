package com.kmm.common.utils

import android.content.Context

@Suppress("StaticFieldLeak")
class AndroidApp {
    companion object {
        // since we are using the applicationContext and not
        // the context per se, nothing is going to leak here
        lateinit var apllicationContext: Context
    }
}