package com.example.minhacalculadoraimc

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificação = findViewById<TextView>(R.id.textview_classificação)
        val result = intent.getFloatExtra("EXTRA_RESULT",0.1F)

        tvResult.text = result.toString()

        val classificação = if (result < 18.50f){
            "Abaixo do Peso"
        }else if (result in 18.50f..24.99f){
            "Normal"
        }else if (result in 25f..29.99f){
            "SobrePeso"
        }else if (result in 30f..39.99f){
            "Obesidade Tipo II"
        }else {
            "Obesidade Tipo III"
        }

        tvClassificação.text = getString(R.string.message_classificação, classificação)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       finish()
        return super.onOptionsItemSelected(item)
    }
}