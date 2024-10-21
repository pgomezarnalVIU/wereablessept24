package com.example.todos.presentation.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todos.presentation.UiEvent
import com.example.todos.presentation.model.Todo
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ListTodoViewModel() : ViewModel() {
    private val _todos: MutableState<List<Todo>> = mutableStateOf(emptyList())
    var todos: State<List<Todo>> = _todos

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        viewModelScope.launch {

        }
    }

}