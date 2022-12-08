package com.kmm.android

import android.app.Application
import android.content.Context
import com.kmm.common.utils.AndroidApplication

class MainApplication: Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        base?.let {
            AndroidApplication.context = it
        }
    }
}