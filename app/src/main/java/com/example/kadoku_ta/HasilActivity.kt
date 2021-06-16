package com.example.kadoku_ta

import android.app.ProgressDialog
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
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
        val momen = intent.getStringExtra("momen").toString()
        val hargaMin = intent.getStringExtra("hargaMin").toString()
        val hargaMax = intent.getStringExtra("hargaMax").toString()
        val umur = intent.getStringExtra("umur").toString()
        val crispExtra = intent.getIntExtra("crispExtra",0)
        val crispAgree = intent.getIntExtra("crispAgree",0)
        val crispCons = intent.getIntExtra("crispCons",0)
        val crispNeuro = intent.getIntExtra("crispNeuro",0)
        val crispOpen = intent.getIntExtra("crispOpen",0)

        val textJk = findViewById<TextView>(R.id.textViewJK)
        val textKar = findViewById<TextView>(R.id.textViewKarakter)
        val textMomen = findViewById<TextView>(R.id.textViewMomen)
        val textUmur = findViewById<TextView>(R.id.textViewUsia)

        textJk.setText("Jenis Kelamin: " + jk.toString())
        textKar.setText("Jenis Kelamin: " + hobi.toString())
        textMomen.setText("Momen: " + momen.toString())
        textUmur.setText("Umur: " + umur.toString())

        val buttonRekom = findViewById<Button>(R.id.buttonRekom)

        buttonRekom.setOnClickListener{
            val q = Volley.newRequestQueue(this)
            val url = "http://192.168.1.117/Apikadoku_TA/public/api/fuzzy"

            var baru = ""
            var kat = ""

            val kateText = findViewById<TextView>(R.id.textViewHasil)
            val textJudul = findViewById<TextView>(R.id.textViewJudul)
            val textHasil = findViewById<TextView>(R.id.textViewHasil)
            val textJenis = findViewById<TextView>(R.id.textViewHasil2)

            textJudul.visibility = View.VISIBLE
            textHasil.visibility = View.VISIBLE
            textJenis.visibility = View.VISIBLE


            var stringRequest = object: StringRequest(
                Request.Method.POST, url,
                Response.Listener<String>{ response->
                    try {
                        val object_ = JSONObject(response)
                        kat = object_.getString("kategori")
//                            val ambil = jsonArray.getString("kategori")//kurung kurawal json array
                        Log.d("test", kat)
                        kateText.text = kat.toString()

//                            Log.d("yow", "masuk try yo")
                    }
                    catch (e: Exception) { // caught while parsing the response
                        e.printStackTrace()
                        print("gagal")
                        Log.e("bakaka", "gagal wkwk")
                    }

                },
                Response.ErrorListener {} )
            {
                //input data penerima kado ke database
                override fun getParams(): Map<String, String> {
                    val params = HashMap<String, String>()
                    params.put("crispExtra", crispExtra.toString())
                    params.put("crispAgree", crispAgree.toString())
                    params.put("crispCons", crispCons.toString())
                    params.put("crispNeuro", crispNeuro.toString())
                    params.put("crispOpen", crispOpen.toString())
                    params.put("karakter", hobi.toString())
                    params.put("momen", momen.toString())
                    params.put("umur", umur.toString())
                    params.put("jk", jk.toString())
                    params.put("hargaMin", hargaMin.toString())
                    params.put("hargaMin", hargaMax.toString())
                    return params
                }
            }
            //eksekusi untuk melakukan insert database
            q.add(stringRequest)

            //print("button oke")
            Log.d("tes variable", kat)


        }

    }
}