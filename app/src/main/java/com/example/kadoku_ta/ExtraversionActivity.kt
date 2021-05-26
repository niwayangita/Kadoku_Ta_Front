package com.example.kadoku_ta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import android.os.Bundle as Bundle

class ExtraversionActivity : AppCompatActivity() {
    companion object{
        var E1 = 0
        var E2 = 0
        var E3 = 0
        var E4 = 0
        var E5 = 0
        var E6 = 0
        var E7 = 0
        var E8 = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extraversion)

        //terima intent dari filter rekomendasi
        val jk = intent.getStringExtra("jk").toString()
        val hobi = intent.getStringExtra("hobi").toString()

        //deklarasi variabel radiogrup extraversion
        val radioE1 = findViewById<RadioGroup>(R.id.radioGroupE1)
        val radioE2 = findViewById<RadioGroup>(R.id.radioGroupE2)
        val radioE3 = findViewById<RadioGroup>(R.id.radioGroupE3)
        val radioE4 = findViewById<RadioGroup>(R.id.radioGroupE4)
        val radioE5 = findViewById<RadioGroup>(R.id.radioGroupE5)
        val radioE6 = findViewById<RadioGroup>(R.id.radioGroupE6)
        val radioE7 = findViewById<RadioGroup>(R.id.radioGroupE7)
        val radioE8 = findViewById<RadioGroup>(R.id.radioGroupE8)

        radioE1.setOnCheckedChangeListener{group, checkedId ->
            E1 = when(checkedId){
                R.id.radioEx10 ->0
                R.id.radioEx11 ->1
                R.id.radioEx12 ->2
                R.id.radioEx13 ->3
                R.id.radioEx14 ->4
                R.id.radioEx15 ->5
                else->0
            }
        }

        radioE2.setOnCheckedChangeListener{group, checkedId ->
            E2 = when(checkedId){
                R.id.radioEx20 ->0
                R.id.radioEx21 ->1
                R.id.radioEx22 ->2
                R.id.radioEx23 ->3
                R.id.radioEx24 ->4
                R.id.radioEx25 ->5
                else->0
            }
        }

        radioE3.setOnCheckedChangeListener{group, checkedId ->
            E3 = when(checkedId){
                R.id.radioEx30 ->0
                R.id.radioEx31 ->1
                R.id.radioEx32 ->2
                R.id.radioEx33 ->3
                R.id.radioEx34 ->4
                R.id.radioEx35 ->5
                else->0
            }
        }

        radioE4.setOnCheckedChangeListener{group, checkedId ->
            E4 = when(checkedId){
                R.id.radioEx40 ->0
                R.id.radioEx41 ->1
                R.id.radioEx42 ->2
                R.id.radioEx43 ->3
                R.id.radioEx44 ->4
                R.id.radioEx45 ->5
                else->0
            }
        }

        radioE5.setOnCheckedChangeListener{group, checkedId ->
            E5 = when(checkedId){
                R.id.radioEx50 ->0
                R.id.radioEx51 ->1
                R.id.radioEx52 ->2
                R.id.radioEx53 ->3
                R.id.radioEx54 ->4
                R.id.radioEx55 ->5
                else->0
            }
        }

        radioE6.setOnCheckedChangeListener{group, checkedId ->
            E6 = when(checkedId){
                R.id.radioEx60 ->0
                R.id.radioEx61 ->1
                R.id.radioEx62 ->2
                R.id.radioEx63 ->3
                R.id.radioEx64 ->4
                R.id.radioEx65 ->5
                else->0
            }
        }

        radioE7.setOnCheckedChangeListener{group, checkedId ->
            E7 = when(checkedId){
                R.id.radioEx70 ->0
                R.id.radioEx71 ->1
                R.id.radioEx72 ->2
                R.id.radioEx73 ->3
                R.id.radioEx74 ->4
                R.id.radioEx75 ->5
                else->0
            }
        }

        radioE8.setOnCheckedChangeListener{group, checkedId ->
            E8 = when(checkedId){
                R.id.radioEx80 ->0
                R.id.radioEx81 ->1
                R.id.radioEx82 ->2
                R.id.radioEx83 ->3
                R.id.radioEx84 ->4
                R.id.radioEx85 ->5
                else->0
            }
        }


        //val text3 = findViewById<TextView>(R.id.textView4)

        val btnNext = findViewById<Button>(R.id.buttonNextCons)

        btnNext.setOnClickListener{
            var totalExtra = E1+E2+E3+E4+E5+E6+E7+E8
//            Toast.makeText(applicationContext, totalExtra.toString(),
//                    Toast.LENGTH_SHORT).show()

            val intent = Intent(this, AgreeablenessActivity::class.java)
            intent.putExtra("jk", jk)
            intent.putExtra("hobi", hobi)
            intent.putExtra("crispExtra", totalExtra)
            startActivity(intent)

        }
    }
}