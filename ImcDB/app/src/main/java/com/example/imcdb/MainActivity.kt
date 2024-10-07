package com.example.imcdb

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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.imcdb.screens.Home
import com.example.imcdb.ui.theme.ImcDBTheme
import com.example.imcdb.viewmodel.ImcViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImcDBTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Crear el view model
                    val usuariosViewModel = viewModel<ImcViewModel>()
                    Home(usuariosViewModel,innerPadding)
                }
            }
        }
    }
}

