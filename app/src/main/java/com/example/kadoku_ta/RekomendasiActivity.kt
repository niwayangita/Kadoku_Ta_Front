 package com.example.kadoku_ta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text

 class RekomendasiActivity : AppCompatActivity() {
    companion object{
        var JenisKelamin = ""
        var Hobi = ""
        var Momen= ""
        var Umur = ""
        var HargaBawah = ""
        var HargaAtas = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rekomendasi)

        val btnRekom = findViewById<Button>(R.id.buttonRekom)
        val radioJK = findViewById<RadioGroup>(R.id.radioGroupJK)
        val spinnerHobi = findViewById<Spinner>(R.id.spinnerHobi)
        val spinnerMomen = findViewById<Spinner>(R.id.spinnerMomen)
        val spinnerUmur = findViewById<Spinner>(R.id.spinnerUmur)
        val hargaMin = findViewById(R.id.editTextMin) as EditText
        val hargaMax = findViewById(R.id.editTextMaks) as EditText

        Hobi= spinnerHobi.selectedItem.toString()
        Momen = spinnerMomen.selectedItem.toString()
        Umur = spinnerUmur.selectedItem.toString()
        HargaBawah = hargaMin.text.toString()
        HargaAtas = hargaMax.text.toString()

        radioJK.setOnCheckedChangeListener{group, checkedId ->
            JenisKelamin= when(checkedId){
                    R.id.radioButtonLaki ->"laki"
                    R.id.radioButtonPerempuan -> "perempuan"
                else->""
            }
        }

        btnRekom.setOnClickListener{
            // Get the checked radio button id from radio group
//            var id: Int = radioJK.checkedRadioButtonId
//            if (id!=-1){ // If any radio button checked from radio group
//                // Get the instance of radio button using id
//                val radio: RadioButton = findViewById(id)
//                Toast.makeText(applicationContext,"On button click :" +
//                        " ${radio.text}",
//                    Toast.LENGTH_SHORT).show()
//            }else{
//                // If no radio button checked in this radio group
//                Toast.makeText(applicationContext,"On button click :" +
//                        " nothing selected",
//                    Toast.LENGTH_SHORT).show()
//            }

            //startActivity<ExtraversionActivity>(JenisKelamin to JenisKelamin)
            val intent = Intent(this, ExtraversionActivity::class.java)
            intent.putExtra("jk", JenisKelamin)
            intent.putExtra("hobi", Hobi)
            intent.putExtra("momen", Momen)
            intent.putExtra("hargaMin", HargaBawah)
            intent.putExtra("hargaMax", HargaAtas)
            intent.putExtra("umur", Umur)
            startActivity(intent)

//            Toast.makeText(applicationContext, Hobi,
//                    Toast.LENGTH_SHORT).show()
        }

//        btnRekom.setOnClickListener{
//            val intent = Intent(this, RekomendasiActivity::class.java)
//            startActivity(intent)
//        }

    }
}