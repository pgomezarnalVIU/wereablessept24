package com.example.todos.retrofit

import com.example.todos.presentation.model.Todo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface TodoApi {
        @GET("/todos")
        suspend fun getTodos() :  List<Todo>

        // https:.../todos?key=value
        @GET("/todos")
        suspend fun getItem(@Query("key") key: String) : Todo

        @GET("/todos/{id}")
        suspend fun getTodo(@Path("id") id: Int) : Todo

        @POST("/todos")
        suspend fun createTodo(@Body() todo: Todo) : Todo

        @PUT("/todos/{id}")
        suspend fun updateTodo(@Path("id") id: Int, @Body() todo: Todo) : Todo
}