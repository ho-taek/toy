package com.example.toy.architecture.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MviViewModel : ViewModel() {

    //상태 담는 stateFlow
    private val _viewState = MutableStateFlow<MviState>(MviState.Loading)
    val viewState: StateFlow<MviState> get() = _viewState


    //Intent로 넘어온 것들 처리
    fun processIntent(intent: MviIntent) {
        when (intent) {
            is MviIntent.LoadData -> loadData()
            is MviIntent.SelectItem -> selectItem(itemId = intent.itemId)
            is MviIntent.RefreshData -> refreshData()
        }
    }


    private fun loadData() {
        viewModelScope.launch {
            _viewState.value = MviState.Loading
            try {
                // 데이터를 불러와 상태를 업데이트
                val items = listOf("Item 1", "Item 2", "Item 3") // 예시 데이터
                _viewState.value = MviState.DataLoaded(items)
            } catch (e: Exception) {
                _viewState.value = MviState.Error("데이터를 불러오는 중 오류가 발생했습니다.")
            }
        }
    }

    private fun selectItem(itemId: String) {
        // 아이템 선택에 따른 로직 처리 (선택된 아이템의 정보를 활용해 새로운 상태를 설정할 수 있음)
    }

    private fun refreshData() {
        viewModelScope.launch {
            _viewState.value = MviState.Loading
            // 새로고침 로직 처리
        }
    }

}