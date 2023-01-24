package com.kmm.android

import android.app.Application
import android.content.Context
import com.kmm.common.utils.AndroidApp

class MainApplication: Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        base?.let {
            AndroidApp.apllicationContext = it
        }
    }
}