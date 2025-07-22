package com.example.calculonotas22300570

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
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        btnCalcular.setOnClickListener {
            calcular();
        }
    }
    fun calcular(){
        val nota1 = findViewById<EditText>(R.id.nota1)
        val nota2 = findViewById<TextView>(R.id.nota2)
        val total = findViewById<TextView>(R.id.total)


        val resultado = (nota1.text.toString().toFloat() + nota2.text.toString().toFloat()) / 2;
        if (resultado < 7){
            total.setText("Média: ${resultado} - Reprovado")
        }else if (resultado.toInt() == 10){
            total.setText("Média: ${resultado} - Aprovado com Distinção")
        }else if (resultado >= 7){
            total.setText("Média: ${resultado} - Aprovado")
        }


    }
}