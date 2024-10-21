package com.example.todos.presentation.addedit


sealed interface AddEditTodoEvent {
    data class EnteredTitle(val title: String): AddEditTodoEvent
    data object SaveTodo: AddEditTodoEvent
}