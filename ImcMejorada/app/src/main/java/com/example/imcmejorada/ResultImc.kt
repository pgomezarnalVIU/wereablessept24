package com.example.imcmejorada

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.imcmejorada.databinding.ActivityResultImcBinding
import java.text.DecimalFormat

class ResultImc : AppCompatActivity() {

    lateinit var btnReCalculate: Button
    lateinit var txtIMC: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val paquete: Bundle? = intent.extras
        val imc: Number = paquete?.getDouble("IMC") ?: 0f
        txtIMC =findViewById(R.id.txtIMC)
        val df = DecimalFormat("#.##")
        txtIMC.text = df.format(imc).toString()

        //Inicializar el boton
        btnReCalculate =findViewById(R.id.btnReCalculate)
        btnReCalculate.setOnClickListener { onBackPressedDispatcher.onBackPressed() } // Activity dentro de la pila, el anterior

    }

}