package com.example.todos.presentation.model

import kotlinx.serialization.Serializable

@Serializable
data class Todo(val userId: Int = -1, val id: Int = -1, val title: String = "", val completed: Boolean = false)
