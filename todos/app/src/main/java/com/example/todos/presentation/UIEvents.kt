package com.example.todos.presentation

sealed interface UiEvent {
    data class ShowMessage(val message: String) : UiEvent

}