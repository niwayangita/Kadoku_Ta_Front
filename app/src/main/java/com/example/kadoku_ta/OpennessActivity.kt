package com.example.kadoku_ta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

import org.json.JSONObject

class OpennessActivity : AppCompatActivity() {
    val Konfigurasi = Konfigurasi()
    companion object{
        var O1 = 0
        var O2 = 0
        var O3 = 0
        var O4 = 0
        var O5 = 0
        var O6 = 0
        var O7 = 0
        var O8 = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_openness)

        //terima intent dari filter rekomendasi
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

        val radioO1 = findViewById<RadioGroup>(R.id.radioGroupO1)
        val radioO2 = findViewById<RadioGroup>(R.id.radioGroupO2)
        val radioO3 = findViewById<RadioGroup>(R.id.radioGroupO3)
        val radioO4 = findViewById<RadioGroup>(R.id.radioGroupO4)
        val radioO5 = findViewById<RadioGroup>(R.id.radioGroupO5)
        val radioO6 = findViewById<RadioGroup>(R.id.radioGroupO6)
        val radioO7 = findViewById<RadioGroup>(R.id.radioGroupO7)
        val radioO8 = findViewById<RadioGroup>(R.id.radioGroupO8)

        radioO1.setOnCheckedChangeListener{group, checkedId ->
            O1 = when(checkedId){
                R.id.radioOp10 ->0
                R.id.radioOp11 ->1
                R.id.radioOp12 ->2
                R.id.radioOp13 ->3
                R.id.radioOp14 ->4
                R.id.radioOp15 ->5
                else->0
            }
        }

        radioO2.setOnCheckedChangeListener{group, checkedId ->
            O2 = when(checkedId){
                R.id.radioOp20 ->0
                R.id.radioOp21 ->1
                R.id.radioOp22 ->2
                R.id.radioOp23 ->3
                R.id.radioOp24 ->4
                R.id.radioOp25 ->5
                else->0
            }
        }

        radioO3.setOnCheckedChangeListener{group, checkedId ->
            O3 = when(checkedId){
                R.id.radioOp30 ->0
                R.id.radioOp31 ->1
                R.id.radioOp32 ->2
                R.id.radioOp33 ->3
                R.id.radioOp34 ->4
                R.id.radioOp35 ->5
                else->0
            }
        }

        radioO4.setOnCheckedChangeListener{group, checkedId ->
            O4 = when(checkedId){
                R.id.radioOp40 ->0
                R.id.radioOp41 ->1
                R.id.radioOp42 ->2
                R.id.radioOp43 ->3
                R.id.radioOp44 ->4
                R.id.radioOp45 ->5
                else->0
            }
        }

        radioO5.setOnCheckedChangeListener{group, checkedId ->
            O5 = when(checkedId){
                R.id.radioOp50 ->0
                R.id.radioOp51 ->1
                R.id.radioOp52 ->2
                R.id.radioOp53 ->3
                R.id.radioOp54 ->4
                R.id.radioOp55 ->5
                else->0
            }
        }

        radioO6.setOnCheckedChangeListener{group, checkedId ->
            O6 = when(checkedId){
                R.id.radioOp60 ->0
                R.id.radioOp61 ->1
                R.id.radioOp62 ->2
                R.id.radioOp63 ->3
                R.id.radioOp64 ->4
                R.id.radioOp65 ->5
                else->0
            }
        }

        radioO7.setOnCheckedChangeListener{group, checkedId ->
            O7 = when(checkedId){
                R.id.radioOp70 ->0
                R.id.radioOp71 ->1
                R.id.radioOp72 ->2
                R.id.radioOp73 ->3
                R.id.radioOp74 ->4
                R.id.radioOp75 ->5
                else->0
            }
        }

        radioO8.setOnCheckedChangeListener{group, checkedId ->
            O8 = when(checkedId){
                R.id.radioOp80 ->0
                R.id.radioOp81 ->1
                R.id.radioOp82 ->2
                R.id.radioOp83 ->3
                R.id.radioOp84 ->4
                R.id.radioOp85 ->5
                else->0
            }
        }

        val btnNext = findViewById<Button>(R.id.buttonHasil)

        btnNext.setOnClickListener{
            if(radioO1.checkedRadioButtonId ==-1){
                Toast.makeText(getApplicationContext(), "Nomor 1 belum diisi", Toast.LENGTH_SHORT).show();
            }

            else if(radioO2.checkedRadioButtonId ==-1) {
                Toast.makeText(getApplicationContext(), "Nomor 2 belum diisi", Toast.LENGTH_SHORT)
                    .show();
            }

            else if(radioO3.checkedRadioButtonId ==-1){
                Toast.makeText(getApplicationContext(), "Nomor 3 belum diisi", Toast.LENGTH_SHORT).show();
            }

            else if(radioO4.checkedRadioButtonId ==-1){
                Toast.makeText(getApplicationContext(), "Nomor 4 belum diisi", Toast.LENGTH_SHORT).show();
            }

            else if(radioO5.checkedRadioButtonId ==-1){
                Toast.makeText(getApplicationContext(), "Nomor 5 belum diisi", Toast.LENGTH_SHORT).show();
            }

            else if(radioO6.checkedRadioButtonId ==-1){
                Toast.makeText(getApplicationContext(), "Nomor 6 belum diisi", Toast.LENGTH_SHORT).show();
            }

            else if(radioO7.checkedRadioButtonId ==-1){
                Toast.makeText(getApplicationContext(), "Nomor 7 belum diisi", Toast.LENGTH_SHORT).show();
            }

            else if(radioO8.checkedRadioButtonId ==-1){
                Toast.makeText(getApplicationContext(), "Nomor 8 belum diisi", Toast.LENGTH_SHORT).show();
            }

            else{
                var totalOpen = O1+O2+O3+O4+O5+O6+O7+O8
                Toast.makeText(applicationContext, totalOpen.toString(),
                    Toast.LENGTH_SHORT).show()

                val q = Volley.newRequestQueue(this)
                val url = "http://192.168.1.117/Apikadoku_TA/public/api/fuzzy"

                var baru = ""
                var kat = ""

                var stringRequest = object: StringRequest(
                    Request.Method.POST, url,
                    Response.Listener<String>{ response->
                        try {
                            val object_ = JSONObject(response)
                            kat = object_.getString("kategori")
//                            val ambil = jsonArray.getString("kategori")//kurung kurawal json array
                            //Log.d("test", kat)
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
                    //input data Mahasiswa ke database
                    override fun getParams(): Map<String, String> {
                        val params = HashMap<String, String>()
                        params.put("crispExtra", crispExtra.toString())
                        params.put("crispAgree", crispAgree.toString())
                        params.put("crispCons", crispCons.toString())
                        params.put("crispNeuro", crispNeuro.toString())
                        params.put("crispOpen", totalOpen.toString())
                        return params
                    }
                }
                //eksekusi untuk melakukan insert database
                q.add(stringRequest)

                //print("button oke")
                Log.d("tes variable", kat)

                val intent = Intent(this, HasilActivity::class.java)
                intent.putExtra("jk", jk)
                intent.putExtra("hobi", hobi)
                intent.putExtra("momen", momen)
                intent.putExtra("hargaMin", hargaMin)
                intent.putExtra("hargaMax", hargaMax)
                intent.putExtra("umur", umur)
                intent.putExtra("crispExtra", crispExtra)
                intent.putExtra("crispAgree", crispAgree)
                intent.putExtra("crispCons", crispCons)
                intent.putExtra("crispNeuro", crispNeuro)
                intent.putExtra("crispOpen", totalOpen)
                intent.putExtra("kategori", kat)
                startActivity(intent)


            }
            }


    }
}