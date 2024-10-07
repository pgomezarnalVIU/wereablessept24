package com.example.imcmejorada

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {

    //Variables de calculo  o funcionamiento
    private var mujerSeleccionada:Boolean = true
    private var altura:Int = 120
    private var peso:Int = 70
    private var edad:Int = 30

    //Componentes
    private lateinit var cvHombre: CardView
    private lateinit var cvMujer:CardView
    private lateinit var txtAltura: TextView
    private lateinit var rngAltura: RangeSlider
    private lateinit var txtPeso: TextView
    private lateinit var txtEdad: TextView
    private lateinit var btnMasPeso: FloatingActionButton
    private lateinit var btnMenosPeso: FloatingActionButton
    private lateinit var btnMasEdad: FloatingActionButton
    private lateinit var btnMenosEdad: FloatingActionButton
    private lateinit var btnCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Funcion de inicializacion de componentes
        initComponentes()
        initListener()
    }

    private fun initComponentes(){
        cvHombre = findViewById(R.id.cvHombre)
        cvMujer = findViewById(R.id.cvMujer)

        txtAltura = findViewById(R.id.txtAltura)
        txtAltura.text = "${altura.toString()} cm"
        rngAltura = findViewById(R.id.rngAltura)

        txtEdad = findViewById(R.id.txtEdad)
        txtEdad.text = "${edad.toString()}"
        btnMasEdad = findViewById(R.id.btnMasEdad)
        btnMenosEdad = findViewById(R.id.btnMenosEdad)

        txtPeso = findViewById(R.id.txtPeso)
        btnMasPeso = findViewById(R.id.btnMasPeso)
        btnMenosPeso = findViewById(R.id.btnMenosPeso)
        txtPeso.text = peso.toString()

        btnCalculate = findViewById(R.id.btnCalculate)

    }


    private fun initListener(){
        //CardView
        //cvHombre.setOnClickListener{cambiarColorSexo(false)}
        //cvMujer.setOnClickListener{cambiarColorSexo(true)}

        //Listener de altura
        rngAltura.addOnChangeListener { slider, value, fromUser ->
            altura = value.toInt()
            txtAltura.text = "${altura.toString()} cm"
        }

        //Listener de Peso
        btnMasPeso.setOnClickListener {
            if(peso<120) peso += 1
            setPeso()
        }
        btnMenosPeso.setOnClickListener {
            if(peso>30) peso -= 1
            setPeso()
        }

        //Listener de Edad
        btnMasEdad.setOnClickListener {
            if(edad<100) edad += 1
            setEdad()
        }
        btnMenosEdad.setOnClickListener {
            if(edad>18) edad -= 1
            setEdad()
        }

        //Calculo del IMC

        btnCalculate.setOnClickListener{
            val imc:Double = calcularIMC()
            val intent = Intent(this,ResultImc::class.java)
            intent.putExtra("IMC",imc)
            startActivity(intent)
        }
    }

    private fun setPeso() {
        txtPeso.text = peso.toString()
    }

    private fun setEdad() {
        txtEdad.text = edad.toString()
    }


    fun cambiarColorSexo(esMujer:Boolean){
        if(esMujer){
            cvMujer.setCardBackgroundColor(ContextCompat.getColor(this,R.color.imcM_card_selected))
            cvHombre.setCardBackgroundColor(ContextCompat.getColor(this,R.color.imcM_card_noselected))
            mujerSeleccionada = true
        }else{
            cvMujer.setCardBackgroundColor(ContextCompat.getColor(this,R.color.imcM_card_noselected))
            cvHombre.setCardBackgroundColor(ContextCompat.getColor(this,R.color.imcM_card_selected))
            mujerSeleccionada = false
        }
    }

    private fun calcularIMC():Double{
        val pesoDoble:Double=peso.toDouble()
        val alturaDoble:Double = (altura.toDouble())/100
        return pesoDoble / (alturaDoble*alturaDoble)
    }
}

