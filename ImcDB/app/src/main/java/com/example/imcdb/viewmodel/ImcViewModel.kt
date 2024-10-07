package com.example.imcdb.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import com.example.imcdb.data.UserImc
import com.example.imcdb.data.usuarios

class ImcViewModel:ViewModel() {

    //Las variables que estaran en memoria y seran observables
    private val _usuarios: MutableState<MutableList<UserImc>> = mutableStateOf(mutableListOf<UserImc>())
    var usuariosVM: State<List<UserImc>> = _usuarios

    init{
        //Cargamos los datos iniciales
        _usuarios.value = usuarios
    }

    //Realiza una nueva inserción dentro de nuestra lista de usuariosIMC
    fun onCreateIMC(usuario:UserImc){
        _usuarios.value = _usuarios.value.toMutableList().apply { add(usuario) }
    }
}