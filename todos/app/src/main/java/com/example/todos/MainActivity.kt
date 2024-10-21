package com.example.todos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.todos.presentation.addedit.AddTodoScreen
import com.example.todos.presentation.addedit.AddTodoViewModel
import com.example.todos.presentation.list.ListTodosScreen
import com.example.todos.presentation.list.ListTodoViewModel
import com.example.todos.utils.AddTodoScreen
import com.example.todos.utils.TodosListScreen
import com.knowledgespike.todos.ui.theme.TodosTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = TodosListScreen,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<TodosListScreen> {


                            val vm = viewModel<ListTodoViewModel>()
                            ListTodosScreen(navController, vm)
                        }
                        composable<AddTodoScreen> { navBackStackEntry ->

                            val args: AddTodoScreen = navBackStackEntry.toRoute<AddTodoScreen>()

                            val vm = viewModel<AddTodoViewModel>() {
                                AddTodoViewModel(args.id)
                            }
                            AddTodoScreen(navController, vm)
                        }
                    }

                }
            }
        }
    }
}