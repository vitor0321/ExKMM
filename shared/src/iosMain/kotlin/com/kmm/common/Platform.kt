package com.kmm.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual abstract class BaseSharesViewModel {

    actual val scope: CoroutineScope = MainScope()

    protected actual fun onCleared() {
        // outras coisas que deseja limpar
    }

    fun clear(){
        onCleared()
        scope.cancel()
    }
}