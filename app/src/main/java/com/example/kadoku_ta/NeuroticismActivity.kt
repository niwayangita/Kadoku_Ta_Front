package com.example.kadoku_ta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast

class NeuroticismActivity : AppCompatActivity() {
    companion object{
        var N1 = 0
        var N2 = 0
        var N3 = 0
        var N4 = 0
        var N5 = 0
        var N6 = 0
        var N7 = 0
        var N8 = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neuroticism)

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

        val radioN1 = findViewById<RadioGroup>(R.id.radioGroupN1)
        val radioN2 = findViewById<RadioGroup>(R.id.radioGroupN2)
        val radioN3 = findViewById<RadioGroup>(R.id.radioGroupN3)
        val radioN4 = findViewById<RadioGroup>(R.id.radioGroupN4)
        val radioN5 = findViewById<RadioGroup>(R.id.radioGroupN5)
        val radioN6 = findViewById<RadioGroup>(R.id.radioGroupN6)
        val radioN7 = findViewById<RadioGroup>(R.id.radioGroupN7)
        val radioN8 = findViewById<RadioGroup>(R.id.radioGroupN8)

        radioN1.setOnCheckedChangeListener{group, checkedId ->
            N1 = when(checkedId){
                R.id.radioNe10 ->0
                R.id.radioNe11 ->1
                R.id.radioNe12 ->2
                R.id.radioNe13 ->3
                R.id.radioNe14 ->4
                R.id.radioNe15 ->5
                else->0
            }
        }

        radioN2.setOnCheckedChangeListener{group, checkedId ->
            N2 = when(checkedId){
                R.id.radioNe20 ->0
                R.id.radioNe21 ->1
                R.id.radioNe22 ->2
                R.id.radioNe23 ->3
                R.id.radioNe24 ->4
                R.id.radioNe25 ->5
                else->0
            }
        }

        radioN3.setOnCheckedChangeListener{group, checkedId ->
            N3 = when(checkedId){
                R.id.radioNe30 ->0
                R.id.radioNe31 ->1
                R.id.radioNe32 ->2
                R.id.radioNe33 ->3
                R.id.radioNe34 ->4
                R.id.radioNe35 ->5
                else->0
            }
        }

        radioN4.setOnCheckedChangeListener{group, checkedId ->
            N4 = when(checkedId){
                R.id.radioNe40 ->0
                R.id.radioNe41 ->1
                R.id.radioNe42 ->2
                R.id.radioNe43 ->3
                R.id.radioNe44 ->4
                R.id.radioNe45 ->5
                else->0
            }
        }

        radioN5.setOnCheckedChangeListener{group, checkedId ->
            N5 = when(checkedId){
                R.id.radioNe50 ->0
                R.id.radioNe51 ->1
                R.id.radioNe52 ->2
                R.id.radioNe53 ->3
                R.id.radioNe54 ->4
                R.id.radioNe55 ->5
                else->0
            }
        }

        radioN6.setOnCheckedChangeListener{group, checkedId ->
            N6 = when(checkedId){
                R.id.radioNe60 ->0
                R.id.radioNe61 ->1
                R.id.radioNe62 ->2
                R.id.radioNe63 ->3
                R.id.radioNe64 ->4
                R.id.radioNe65 ->5
                else->0
            }
        }

        radioN7.setOnCheckedChangeListener{group, checkedId ->
            N7 = when(checkedId){
                R.id.radioNe70 ->0
                R.id.radioNe71 ->1
                R.id.radioNe72 ->2
                R.id.radioNe73 ->3
                R.id.radioNe74 ->4
                R.id.radioNe75 ->5
                else->0
            }
        }

        radioN8.setOnCheckedChangeListener{group, checkedId ->
            N8 = when(checkedId){
                R.id.radioNe80 ->0
                R.id.radioNe81 ->1
                R.id.radioNe82 ->2
                R.id.radioNe83 ->3
                R.id.radioNe84 ->4
                R.id.radioNe85 ->5
                else->0
            }
        }

        val btnNext = findViewById<Button>(R.id.buttonNextOpen)

        btnNext.setOnClickListener {
            if (radioN1.checkedRadioButtonId == -1) {
                Toast.makeText(getApplicationContext(), "Nomor 1 belum diisi", Toast.LENGTH_SHORT)
                    .show();
            } else if (radioN2.checkedRadioButtonId == -1) {
                Toast.makeText(getApplicationContext(), "Nomor 2 belum diisi", Toast.LENGTH_SHORT)
                    .show();
            } else if (radioN3.checkedRadioButtonId == -1) {
                Toast.makeText(getApplicationContext(), "Nomor 3 belum diisi", Toast.LENGTH_SHORT)
                    .show();
            } else if (radioN4.checkedRadioButtonId == -1) {
                Toast.makeText(getApplicationContext(), "Nomor 4 belum diisi", Toast.LENGTH_SHORT)
                    .show();
            } else if (radioN5.checkedRadioButtonId == -1) {
                Toast.makeText(getApplicationContext(), "Nomor 5 belum diisi", Toast.LENGTH_SHORT)
                    .show();
            } else if (radioN6.checkedRadioButtonId == -1) {
                Toast.makeText(getApplicationContext(), "Nomor 6 belum diisi", Toast.LENGTH_SHORT)
                    .show();
            } else if (radioN7.checkedRadioButtonId == -1) {
                Toast.makeText(getApplicationContext(), "Nomor 7 belum diisi", Toast.LENGTH_SHORT)
                    .show();
            }
            else if (radioN8.checkedRadioButtonId == -1) {
                Toast.makeText(getApplicationContext(), "Nomor 8 belum diisi", Toast.LENGTH_SHORT)
                    .show();
            }else {
                var totalNeuro = N1 + N2 + N3 + N4 + N5 + N6 + N7 + N8
                Toast.makeText(
                    applicationContext, totalNeuro.toString(),
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(this, OpennessActivity::class.java)
                intent.putExtra("jk", jk)
                intent.putExtra("hobi", hobi)
                intent.putExtra("momen", momen)
                intent.putExtra("hargaMin", hargaMin)
                intent.putExtra("hargaMax", hargaMax)
                intent.putExtra("umur", umur)
                intent.putExtra("crispExtra", crispExtra)
                intent.putExtra("crispAgree", crispAgree)
                intent.putExtra("crispCons", crispCons)
                intent.putExtra("crispNeuro", totalNeuro)
                startActivity(intent)
            }
        }
    }
}