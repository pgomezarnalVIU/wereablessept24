package com.example.imcdb.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.imcdb.data.UserImc

@Composable
fun ImCCard(usuario:UserImc){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .border(width = 1.dp,color= Color.Black,shape= RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            modifier=Modifier.padding(16.dp), text = usuario.fecha.toString()
        )
        Column(modifier=Modifier.padding(16.dp)){
            Text(usuario.usuario)
            Text(usuario.imc.toString())
        }
    }

}