package com.example.toy.architecture.mvi

sealed interface MainState {
    data object isLoading : MainState
    data class DataLoaded(val items : List<String>) : MainState
    data class Error(val message : String) : MainState
}