package com.kmm.common

import kotlinx.coroutines.CoroutineScope

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect abstract class BaseSharesViewModel(){
    val scope: CoroutineScope
    protected fun onCleared()
}