package com.kmm.common.viewmodels

import com.kmm.common.BaseSharesViewModel
import com.kmm.common.utils.CommonLogger
import com.kmm.common.utils.CommonLoggerImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ShimmerViewModel: BaseSharesViewModel() {

    private val _loading = MutableStateFlow(false)
    private val logger: CommonLogger = CommonLoggerImpl()

    val loading: StateFlow<Boolean> = _loading

    fun toggleLoadingState(){
        logger.log("Loading State Triggered")
        scope.launch {
            _loading.emit(_loading.value.not())
        }
    }
}