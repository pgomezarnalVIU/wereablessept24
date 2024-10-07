package com.example.imcdb.data

import java.time.LocalDate

data class UserImc (
    val usuario:String="Paco",
    val imc:Float=0f,
    val fecha:LocalDate? = LocalDate.now()
)

//Lista vacia de resultados de imc
val usuarios = mutableListOf<UserImc>()