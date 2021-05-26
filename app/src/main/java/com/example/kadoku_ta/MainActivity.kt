package com.example.kadoku_ta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRekom = findViewById<Button>(R.id.btnRekomKado)

        btnRekom.setOnClickListener{
            val intent = Intent(this, RekomendasiActivity::class.java)
            startActivity(intent)
        }
    }
}