package com.example.todos.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todos.R
import com.example.todos.presentation.UiEvent
import com.example.todos.presentation.components.TodoCard
import com.example.todos.utils.AddTodoScreen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ListTodosScreen(navController: NavController, viewModel: ListTodoViewModel) {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(AddTodoScreen(-1))
                },
                modifier = Modifier.background(Color.White)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add a todo")
            }
        }
    ) { contentPadding ->

        /*
        LaunchedEffect(true) {
            viewModel.eventFlow.collectLatest { event ->
                when (event) {
                    is UiEvent.ShowMessage -> {
                        snackbarHostState.showSnackbar(message = event.message)
                    }
                }
            }
        }*/


        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(horizontal = 8.dp)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.main_heading),
                style = TextStyle(fontSize = 32.sp)
            )


            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn {
                viewModel.todos.value.forEach { todo ->
                    item{
                        TodoCard(todo,
                            modifier = Modifier.clickable {
                                navController.navigate(AddTodoScreen(todo.id))
                            })
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                }
            }
        }
    }
}