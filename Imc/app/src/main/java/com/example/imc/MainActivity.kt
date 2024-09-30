package com.example.imc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Caturar widgets
        val edtPeso : EditText = findViewById<EditText>(R.id.edtPeso)
        val edtAltura : EditText = findViewById<EditText>(R.id.edtAltura)
        val txtResult : TextView = findViewById<TextView>(R.id.txtResult)
        val btnCalcular: Button = findViewById<Button>(R.id.btnCalcular)

        //Programar el litener
        btnCalcular.setOnClickListener{
            //Calculos
            val pesoNum:Float? = edtPeso.text.toString().toFloatOrNull()
            val alturaNum:Float? = edtAltura.text.toString().toFloatOrNull()
            //println("He apretado el boton")
            if(pesoNum!=null && alturaNum!=null){
                val imc = pesoNum / (alturaNum*alturaNum)
                //Devolver el valor en la caja de texto
                txtResult.text = imc.toString()
            } else {
                txtResult.text = "QUE PASA CONTIGO! ESCRIBE CORRECTOS LOS DATOS"
            }
        }
    }
}