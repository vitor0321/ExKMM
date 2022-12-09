package com.kmm.common.viewmodels

import com.kmm.common.BaseSharesViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ShimmerViewModel: BaseSharesViewModel() {

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun toggleLoadingState(){
        scope.launch {
            _loading.emit(_loading.value.not())
        }
    }
}