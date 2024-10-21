package com.example.todos.repository


import com.example.todos.presentation.model.Todo
import com.example.todos.retrofit.TodoApi
import com.example.todos.utils.Result

class TodoRepository(val api: TodoApi) {
    suspend fun getTodos(): Result<List<Todo>> {
        val response = try {
            api.getTodos()
        } catch (e: Exception) {
            return Result.Error(e.message ?: "Unknown error")
        }
        return Result.Success(response)
    }

    suspend fun getTodo(id: Int) : Result<Todo> {
        val response = try {
            api.getTodo(id)
        } catch(e: Exception) {
            return Result.Error(e.message ?: "Unknown error")
        }
        return Result.Success(response)
    }

    suspend fun createTodo(todo: Todo): Result<Todo> {
        val response = try {
            api.createTodo(todo)
        } catch(e: Exception) {
            return Result.Error(e.message ?: "Unknown error")
        }
        return Result.Success(response)

    }

    suspend fun updateTodo(todo: Todo): Result<Todo> {
        val response = try {
            api.updateTodo(todo.id, todo)
        } catch(e: Exception) {
            return Result.Error(e.message ?: "Unknown error")
        }
        return Result.Success(response)

    }
}