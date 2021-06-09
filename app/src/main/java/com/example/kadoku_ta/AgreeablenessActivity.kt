package com.example.kadoku_ta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast

class AgreeablenessActivity : AppCompatActivity() {
    companion object{
        var A1 = 0
        var A2 = 0
        var A3 = 0
        var A4 = 0
        var A5 = 0
        var A6 = 0
        var A7 = 0
        var A8 = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agreeableness)

        //terima intent dari filter rekomendasi
        val jk = intent.getStringExtra("jk").toString()
        val hobi = intent.getStringExtra("hobi").toString()
        val crispExtra = intent.getIntExtra("crispExtra",0)

        //deklarasi variabel radiogrup extraversion
        val radioA1 = findViewById<RadioGroup>(R.id.radioGroupA1)
        val radioA2 = findViewById<RadioGroup>(R.id.radioGroupA2)
        val radioA3 = findViewById<RadioGroup>(R.id.radioGroupA3)
        val radioA4 = findViewById<RadioGroup>(R.id.radioGroupA4)
        val radioA5 = findViewById<RadioGroup>(R.id.radioGroupA5)
        val radioA6 = findViewById<RadioGroup>(R.id.radioGroupA6)
        val radioA7 = findViewById<RadioGroup>(R.id.radioGroupA7)
        val radioA8 = findViewById<RadioGroup>(R.id.radioGroupA8)

        radioA1.setOnCheckedChangeListener{group, checkedId ->
            A1 = when(checkedId){
                R.id.radioAg10 ->0
                R.id.radioAg11 ->1
                R.id.radioAg12 ->2
                R.id.radioAg13 ->3
                R.id.radioAg14 ->4
                R.id.radioAg15 ->5
                else->0
            }
        }

        radioA2.setOnCheckedChangeListener{group, checkedId ->
            A2 = when(checkedId){
                R.id.radioAg20 ->0
                R.id.radioAg21 ->1
                R.id.radioAg22 ->2
                R.id.radioAg23 ->3
                R.id.radioAg24 ->4
                R.id.radioAg25 ->5
                else->0
            }
        }

        radioA3.setOnCheckedChangeListener{group, checkedId ->
            A3 = when(checkedId){
                R.id.radioAg30 ->0
                R.id.radioAg31 ->1
                R.id.radioAg32 ->2
                R.id.radioAg33 ->3
                R.id.radioAg34 ->4
                R.id.radioAg35 ->5
                else->0
            }
        }

        radioA4.setOnCheckedChangeListener{group, checkedId ->
            A4 = when(checkedId){
                R.id.radioAg40 ->0
                R.id.radioAg41 ->1
                R.id.radioAg42 ->2
                R.id.radioAg43 ->3
                R.id.radioAg44 ->4
                R.id.radioAg45 ->5
                else->0
            }
        }

        radioA5.setOnCheckedChangeListener{group, checkedId ->
            A5 = when(checkedId){
                R.id.radioAg50 ->0
                R.id.radioAg51 ->1
                R.id.radioAg52 ->2
                R.id.radioAg53 ->3
                R.id.radioAg54 ->4
                R.id.radioAg55 ->5
                else->0
            }
        }

        radioA6.setOnCheckedChangeListener{group, checkedId ->
            A6 = when(checkedId){
                R.id.radioAg60 ->0
                R.id.radioAg61 ->1
                R.id.radioAg62 ->2
                R.id.radioAg63 ->3
                R.id.radioAg64 ->4
                R.id.radioAg65 ->5
                else->0
            }
        }

        radioA7.setOnCheckedChangeListener{group, checkedId ->
            A7 = when(checkedId){
                R.id.radioAg70 ->0
                R.id.radioAg71 ->1
                R.id.radioAg72 ->2
                R.id.radioAg73 ->3
                R.id.radioAg74 ->4
                R.id.radioAg75 ->5
                else->0
            }
        }

        radioA8.setOnCheckedChangeListener{group, checkedId ->
            A8 = when(checkedId){
                R.id.radioAg80 ->0
                R.id.radioAg81 ->1
                R.id.radioAg82 ->2
                R.id.radioAg83 ->3
                R.id.radioAg84 ->4
                R.id.radioAg85 ->5
                else->0
            }
        }

        val btnNext = findViewById<Button>(R.id.buttonNextCons)



        btnNext.setOnClickListener{
            if(radioA1.checkedRadioButtonId ==-1){
                Toast.makeText(getApplicationContext(), "Nomor 1 belum diisi", Toast.LENGTH_SHORT).show();
            }

            else if(radioA2.checkedRadioButtonId ==-1) {
                Toast.makeText(getApplicationContext(), "Nomor 2 belum diisi", Toast.LENGTH_SHORT)
                    .show();
            }

            else if(radioA3.checkedRadioButtonId ==-1){
                Toast.makeText(getApplicationContext(), "Nomor 3 belum diisi", Toast.LENGTH_SHORT).show();
            }

            else if(radioA4.checkedRadioButtonId ==-1){
                Toast.makeText(getApplicationContext(), "Nomor 4 belum diisi", Toast.LENGTH_SHORT).show();
            }

            else if(radioA5.checkedRadioButtonId ==-1){
                Toast.makeText(getApplicationContext(), "Nomor 5 belum diisi", Toast.LENGTH_SHORT).show();
            }

            else if(radioA6.checkedRadioButtonId ==-1){
                Toast.makeText(getApplicationContext(), "Nomor 6 belum diisi", Toast.LENGTH_SHORT).show();
            }

            else if(radioA7.checkedRadioButtonId ==-1){
                Toast.makeText(getApplicationContext(), "Nomor 7 belum diisi", Toast.LENGTH_SHORT).show();
            }

            else {
                var totalAgree = A1 + A2 + A3 + A4 + A5 + A6 + A7 + A8
//            Toast.makeText(applicationContext, totalAgree.toString(),
//                    Toast.LENGTH_SHORT).show()
                //kirim data ke intent cons
                val intent = Intent(this, ConscientiousnessActivity::class.java)
                intent.putExtra("jk", jk)
                intent.putExtra("hobi", hobi)
                intent.putExtra("religius", A6)
                intent.putExtra("crispExtra", crispExtra)
                intent.putExtra("crispAgree", totalAgree)
                startActivity(intent)

            }
        }
    }
}