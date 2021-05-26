package com.example.kadoku_ta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast

class ConscientiousnessActivity : AppCompatActivity() {
    companion object{
        var C1 = 0
        var C2 = 0
        var C3 = 0
        var C4 = 0
        var C5 = 0
        var C6 = 0
        var C7 = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conscientiousness)

        val jk = intent.getStringExtra("jk").toString()
        val hobi = intent.getStringExtra("hobi").toString()
        val crispExtra = intent.getIntExtra("crispExtra",0)
        val crispAgree = intent.getIntExtra("crispAgree",0)
        val religius = intent.getIntExtra("religius",0)

        //deklarasi variabel radiogrup extraversion
        val radioC1 = findViewById<RadioGroup>(R.id.radioGroupC1)
        val radioC2 = findViewById<RadioGroup>(R.id.radioGroupC2)
        val radioC3 = findViewById<RadioGroup>(R.id.radioGroupC3)
        val radioC4 = findViewById<RadioGroup>(R.id.radioGroupC4)
        val radioC5 = findViewById<RadioGroup>(R.id.radioGroupC5)
        val radioC6 = findViewById<RadioGroup>(R.id.radioGroupC6)
        val radioC7 = findViewById<RadioGroup>(R.id.radioGroupC7)

        radioC1.setOnCheckedChangeListener{group, checkedId ->
            C1 = when(checkedId){
                R.id.radioCo10 ->0
                R.id.radioCo11 ->1
                R.id.radioCo12 ->2
                R.id.radioCo13 ->3
                R.id.radioCo14 ->4
                R.id.radioCo15 ->5
                else->0
            }
        }

        radioC2.setOnCheckedChangeListener{group, checkedId ->
            C2 = when(checkedId){
                R.id.radioCo20 ->0
                R.id.radioCo21 ->1
                R.id.radioCo22 ->2
                R.id.radioCo23 ->3
                R.id.radioCo24 ->4
                R.id.radioCo25 ->5
                else->0
            }
        }

        radioC3.setOnCheckedChangeListener{group, checkedId ->
            C3 = when(checkedId){
                R.id.radioCo30 ->0
                R.id.radioCo31 ->1
                R.id.radioCo32 ->2
                R.id.radioCo33 ->3
                R.id.radioCo34 ->4
                R.id.radioCo35 ->5
                else->0
            }
        }

        radioC4.setOnCheckedChangeListener{group, checkedId ->
            C4 = when(checkedId){
                R.id.radioCo40 ->0
                R.id.radioCo41 ->1
                R.id.radioCo42 ->2
                R.id.radioCo43 ->3
                R.id.radioCo44 ->4
                R.id.radioCo45 ->5
                else->0
            }
        }

        radioC5.setOnCheckedChangeListener{group, checkedId ->
            C5 = when(checkedId){
                R.id.radioCo50 ->0
                R.id.radioCo51 ->1
                R.id.radioCo52 ->2
                R.id.radioCo53 ->3
                R.id.radioCo54 ->4
                R.id.radioCo55 ->5
                else->0
            }
        }

        radioC6.setOnCheckedChangeListener{group, checkedId ->
            C6 = when(checkedId){
                R.id.radioCo60 ->0
                R.id.radioCo61 ->1
                R.id.radioCo62 ->2
                R.id.radioCo63 ->3
                R.id.radioCo64 ->4
                R.id.radioCo65 ->5
                else->0
            }
        }

        radioC7.setOnCheckedChangeListener{group, checkedId ->
            C7 = when(checkedId){
                R.id.radioCo70 ->0
                R.id.radioCo71 ->1
                R.id.radioCo72 ->2
                R.id.radioCo73 ->3
                R.id.radioCo74 ->4
                R.id.radioCo75 ->5
                else->0
            }
        }

        val btnNext = findViewById<Button>(R.id.buttonNextNeuro)

        btnNext.setOnClickListener{
            var totalCons = religius+C1+C2+C3+C4+C5+C6+C7
            Toast.makeText(applicationContext, totalCons.toString(),
                    Toast.LENGTH_SHORT).show()

            val intent = Intent(this, NeuroticismActivity::class.java)
            intent.putExtra("jk", jk)
            intent.putExtra("hobi", hobi)
            intent.putExtra("crispExtra", crispExtra)
            intent.putExtra("crispAgree", crispAgree)
            intent.putExtra("crispCons", totalCons)
            startActivity(intent)

        }


    }
}