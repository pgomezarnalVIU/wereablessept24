package com.example.todos.presentation.addedit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.todos.presentation.UiEvent
import com.example.todos.utils.TodosListScreen
import com.example.todos.R
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AddTodoScreen(
    navController: NavHostController,
    viewModel: AddTodoViewModel
) {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(AddEditTodoEvent.SaveTodo)
                    navController.navigate(TodosListScreen)
                },
            )
            {
                Icon(imageVector = Icons.Default.Save, contentDescription = "Save todo")
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

                    else -> {}
                }
            }
        }*/

        val todo = viewModel.todo.value
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)

        ) {
            Text(
                style = MaterialTheme.typography.headlineLarge,
                text = stringResource(id = R.string.add_edit_todo),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )

            OutlinedTextField(
                value = todo.title,
                label = { Text("ToDo") },
                onValueChange = {
                    viewModel.onEvent(AddEditTodoEvent.EnteredTitle(it))
                },
                singleLine = true,
                textStyle = MaterialTheme.typography.headlineMedium.copy(color = Color.Black),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


