package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class CalculoIMC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Atribuições aos elementos da interface
        val editPeso = findViewById<EditText>(R.id.editTextPeso)
        val editAltura = findViewById<EditText>(R.id.editTextAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val textResultado = findViewById<TextView>(R.id.textViewResultado)

        btnCalcular.setOnClickListener {
            // Obter os valores de peso e altura
            val peso = editPeso.text.toString().toFloatOrNull()
            val altura = editAltura.text.toString().toFloatOrNull()

            if (peso != null && altura != null && altura > 0) {
                val imc = peso / (altura * altura)
                val df = DecimalFormat("#.##")
                val resultadoIMC = "Seu IMC é: ${df.format(imc)}"

                // Determinar a categoria do IMC usando if-else
                val categoria = if (imc < 18.5) {
                    "Abaixo do peso"
                } else if (imc < 25) {
                    "Peso normal"
                } else if (imc < 30) {
                    "Sobrepeso"
                } else if (imc < 35) {
                    "Obesidade grau I"
                } else if (imc < 40) {
                    "Obesidade grau II"
                } else {
                    "Obesidade grau III"
                }

                // Atualizar o TextView com o resultado e a categoria
                textResultado.text = "$resultadoIMC\nCategoria: $categoria"
            } else {
                textResultado.text = "Digite valores válidos para peso e altura."
            }
        }
    }
}
