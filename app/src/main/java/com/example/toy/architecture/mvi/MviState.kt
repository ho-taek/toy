package com.example.toy.architecture.mvi

sealed interface MviState {
    object Loading : MviState
    data class DataLoaded(val items: List<String>) : MviState
    data class Error(val message: String) : MviState
}