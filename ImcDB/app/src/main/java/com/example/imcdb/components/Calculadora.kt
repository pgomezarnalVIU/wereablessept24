package com.example.imcdb.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imcdb.data.UserImc

import com.example.imcdb.ui.theme.DeepPurple100
import com.example.imcdb.viewmodel.ImcViewModel

@Composable
fun Calculadora(usersViewModel: ImcViewModel){
    Column(modifier = Modifier
        .background(color=DeepPurple100, shape = RoundedCornerShape(10.dp))){
        /*Valor del peso y altura*/
        var peso: String by remember { mutableStateOf("") }
        var altura: String by remember { mutableStateOf("") }
        //TITULO
        Row(
            modifier = Modifier.
            fillMaxWidth().padding(16.dp)
            , horizontalArrangement = Arrangement.Center
        ) {
            /*Título del IMC*/
            Text(
                "CALCULADORA IMC",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        //FORM CALCULADORA
        //PESO
        Text("Peso",
            modifier = Modifier.padding(horizontal = 16.dp),
            style = TextStyle(
                fontSize = 16.sp,
                color=Color.Black)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(horizontal=16.dp),
            value = peso,
            textStyle =TextStyle(fontSize = 16.sp),
            onValueChange = {peso = it}
        )
        //ALTURA
        Text("Altura",
            modifier = Modifier.padding(top = 16.dp, start = 16.dp,end= 16.dp),
            style = TextStyle(
                fontSize = 16.sp,
                color=Color.Black)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(horizontal=16.dp),
            value = altura,
            textStyle =TextStyle(fontSize = 16.sp),
            onValueChange = {altura = it}
        )
        //BOTON Calculadora
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
            ,
            onClick = {
                //Calculamos IMC
                var imc = peso.toFloat()/(altura.toFloat()*altura.toFloat())
                usersViewModel.onCreateIMC(UserImc("Paco",imc))
            }
        ) {
            Text("CALCULAR")
        }
    }
}