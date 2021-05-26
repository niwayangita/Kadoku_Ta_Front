package com.example.kadoku_ta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TermActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_term)

        val btnLanjut = findViewById<Button>(R.id.buttonLanjut)
        val jk = intent.getStringExtra("jk").toString()
        val hobi = intent.getStringExtra("hobi").toString()

        btnLanjut.setOnClickListener {
            val intent = Intent(this, ExtraversionActivity::class.java)
            intent.putExtra("jk", jk)
            intent.putExtra("hobi", hobi)
            startActivity(intent)
        }

    }
}