package com.example.imcdb.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imcdb.components.Calculadora
import com.example.imcdb.components.ImCCard
import com.example.imcdb.viewmodel.ImcViewModel

@Composable
fun Home (usersViewModel: ImcViewModel, innerPadding: PaddingValues) {
    Column(modifier = Modifier.padding(innerPadding)){
        //CALCULADORA
        Calculadora(usersViewModel)
        //LISTADO
        //TITULO
        Row(
            modifier = Modifier.
            fillMaxWidth().padding(16.dp)
        ) {
            /*Título del IMC*/
            Text(
                "Registros de cálculos",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        //Listado de usuarios IMC
        LazyColumn (modifier = Modifier.padding(5.dp).fillMaxSize()){
            usersViewModel.usuariosVM.value.forEach{
                usuario->
                 item{
                    ImCCard(usuario)
                 }
            }
        }
    }
}