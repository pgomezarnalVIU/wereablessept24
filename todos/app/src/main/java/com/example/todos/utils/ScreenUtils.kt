package com.example.todos.utils

import kotlinx.serialization.Serializable


@Serializable
object TodosListScreen

@Serializable
data class AddTodoScreen(val id: Int)
