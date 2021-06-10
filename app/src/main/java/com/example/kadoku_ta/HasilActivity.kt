package com.example.kadoku_ta

import android.app.ProgressDialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import android.widget.SimpleAdapter
import android.widget.TextView
import org.json.JSONException
import org.json.JSONObject

class HasilActivity : AppCompatActivity() {
    private var JSON_STRING: String? = null
    val Konfigurasi = Konfigurasi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)


        val jk = intent.getStringExtra("jk").toString()
        val hobi = intent.getStringExtra("hobi").toString()
        val crispExtra = intent.getIntExtra("crispExtra",0)
        val crispAgree = intent.getIntExtra("crispAgree",0)
        val crispCons = intent.getIntExtra("crispCons",0)
        val crispNeuro = intent.getIntExtra("crispNeuro",0)
        val crispOpen = intent.getIntExtra("crispOpen",0)
        val kategori = intent.getStringExtra("kategori")

    }
}