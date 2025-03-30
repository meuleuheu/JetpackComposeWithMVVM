package com.example.mvvm.ui.screen.home

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.example.mvvm.repositories.MainLog
import com.example.mvvm.repositories.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class HomeUiState(
    val test: String
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val log: MainLog,
    private val store: Store
) : ViewModel() {
    private val TAG = "HomeViewModel"

    private val _uiState = MutableStateFlow(HomeUiState(test = ""))
    val uiState = _uiState.asStateFlow()       // state chi doc, ko the update

    fun setUiState(s: String) {
        _uiState.value = _uiState.value.copy(test = s)
    }

    override fun onCleared() {
        log.i(TAG, "onCleared ${store.getValue("test")}")
    }
}