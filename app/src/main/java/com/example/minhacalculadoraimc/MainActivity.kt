package com.example.minhacalculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val btnCalcular:Button = findViewById(R.id.btnCalcular)
        val edPeso:EditText = findViewById(R.id.editext_peso)
        val edAltura:EditText = findViewById(R.id.editext_altura)


        btnCalcular.setOnClickListener {
            val alturaStr = edAltura.text.toString()
            val pesoStr = edPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){

            val altura : Float = edAltura.text.toString().toFloat()
            val peso: Float = edPeso.text.toString().toFloat()

            val alturafinal: Float = altura * altura
            val result : Float = peso/alturafinal

            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", result)
                }

            startActivity(intent)


            } else{
                Toast.makeText(this,"Preencher todos os campos",Toast.LENGTH_LONG).show()
            }
        }
    }
} 