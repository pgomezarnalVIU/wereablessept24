package com.example.todos.presentation.addedit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todos.presentation.UiEvent
import com.example.todos.presentation.model.Todo
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class AddTodoViewModel(id: Int = -1) : ViewModel() {

    private val _todo = mutableStateOf(Todo())
    val todo: State<Todo> = _todo

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        viewModelScope.launch {

        }
    }

    fun onEvent(event: AddEditTodoEvent) {
        when (event) {
            is AddEditTodoEvent.EnteredTitle -> {
                _todo.value = _todo.value.copy(title = event.title)
            }


            AddEditTodoEvent.SaveTodo -> {

            }

        }

    }

}

