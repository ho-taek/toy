package com.example.toy.architecture.mvi

sealed class MviIntent {
    data object LoadData : MviIntent()
    data class SelectItem(val itemId : String) : MviIntent()
    data object RefreshData : MviIntent()
}